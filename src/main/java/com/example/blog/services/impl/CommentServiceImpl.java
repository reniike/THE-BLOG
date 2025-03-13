package com.example.blog.services.impl;

import com.example.blog.data.models.Comment;
import com.example.blog.data.models.Post;
import com.example.blog.data.repositories.CommentRepository;
import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import com.example.blog.services.CommentService;
import com.example.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    @Override
    public CommentDTO createComment(CreateCommentRequest request) {
        Post post = postService.getPost(request.getPostId());

        Comment comment = Comment.builder()
                .comment(request.getComment())
                .post()
                .user()
                .build();
        return null;
    }
}
