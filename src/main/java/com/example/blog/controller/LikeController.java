package com.example.blog.controller;

import com.example.blog.services.LikeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    private ResponseEntity<Void> like(@RequestBody @Valid Long postId) {
        likeService.like(postId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/{id}")
    private ResponseEntity<Void> unlike(@PathVariable("id") Long postId){
        likeService.unlike(postId);
        return ResponseEntity.noContent().build();
    }
}
