package com.example.blog.services.impl;

import com.example.blog.data.models.Comment;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.User;
import com.example.blog.data.repositories.CommentRepository;
import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import com.example.blog.mappers.CommentMapper;
import com.example.blog.services.CommentService;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO createComment(CreateCommentRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        User currentUser = userService.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = postService.getPost(request.getPostId());

        Comment comment = Comment.builder()
                .comment(request.getComment())
                .post(post)
                .user(currentUser)
                .build();

        commentRepository.save(comment);

        return commentMapper.toDto(comment);
    }
}
