package com.example.blog.controller;

import com.example.blog.dtos.CommentDTO;
import com.example.blog.dtos.requests.CreateCommentRequest;
import com.example.blog.dtos.requests.UpdateCommentRequest;
import com.example.blog.services.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CreateCommentRequest request){
        return new ResponseEntity<>(commentService.createComment(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentDTO> updateComment(@Valid @RequestBody UpdateCommentRequest request){
        return new ResponseEntity<>(commentService.updateComment(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments(@RequestParam UUID postId, Pageable pageable){
        return new ResponseEntity<>(commentService.getAllComments(postId, pageable), HttpStatus.OK);
    }

}
