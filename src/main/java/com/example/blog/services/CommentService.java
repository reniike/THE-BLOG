package com.example.blog.services;

import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public interface CommentService {

    CommentDTO createComment(CreateCommentRequest request);
}
