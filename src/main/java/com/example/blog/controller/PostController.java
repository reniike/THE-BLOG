package com.example.blog.controller;

import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;
import com.example.blog.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody @Valid CreatePostRequest request){
        return ResponseEntity.ok(postService.createPost(request));
    }

    @PutMapping
    public ResponseEntity<PostDTO> updatePost(@RequestBody @Valid UpdatePostRequest request){
        return ResponseEntity.ok(postService.editPost(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
