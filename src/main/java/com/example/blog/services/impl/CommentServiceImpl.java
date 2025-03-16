package com.example.blog.services.impl;

import com.example.blog.data.models.Comment;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.User;
import com.example.blog.data.repositories.CommentRepository;
import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import com.example.blog.dtos.requests.UpdateCommentRequest;
import com.example.blog.mappers.CommentMapper;
import com.example.blog.services.CommentService;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.Long;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;
    private final CommentMapper commentMapper;

    @Override
    @PreAuthorize("isAuthenticated()")
    public CommentDTO createComment(CreateCommentRequest request) {
        User currentUser = userService.getCurrentUser();

        Post post = postService.getPost(request.getPostId());

        Comment comment = Comment.builder()
                .comment(request.getComment())
                .post(post)
                .user(currentUser)
                .build();

        commentRepository.save(comment);

        return commentMapper.toDto(comment);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public CommentDTO updateComment(UpdateCommentRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        User currentUser = userService.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        Post post = postService.getPost(request.getPostId());
        Comment comment = commentRepository.findById(request.getCommentId()).orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        if(!comment.getUser().equals(currentUser)) throw new SecurityException("You are not authorized to edit this comment");
        if(!comment.getPost().equals(post)) throw new IllegalArgumentException("Comment does not belong to this post");

        comment.setComment(request.getComment());
        comment.setPost(post);

        commentRepository.save(comment);

        return commentMapper.toDto(comment);
    }

    @Override
    public List<CommentDTO> getAllComments(Long postId, Pageable pageable) {
        List<Comment> comments = commentRepository.getAllByPost_Id(postId, pageable);
        return comments.stream().map(commentMapper::toDto).toList();
    }
}
