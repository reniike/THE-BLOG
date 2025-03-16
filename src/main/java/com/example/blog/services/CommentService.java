package com.example.blog.services;

import com.example.blog.data.models.Comment;
import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import com.example.blog.dtos.requests.UpdateCommentRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.lang.Long;

public interface CommentService {
 
    
    CommentDTO createComment(CreateCommentRequest request);

    CommentDTO updateComment(UpdateCommentRequest request);

    List<CommentDTO> getAllComments(Long postId, Pageable pageable);
}
