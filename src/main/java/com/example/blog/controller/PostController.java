package com.example.blog.controller;

import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(CreatePostRequest request){
        return ResponseEntity.ok(postService.createPost(request));
    }

}
