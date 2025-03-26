package com.example.blog.controller;

import com.example.blog.data.models.Post;
import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;
import com.example.blog.mappers.PostMapper;
import com.example.blog.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.Long;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Qualifier("postMapper")
    private final PostMapper mapper;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody @Valid CreatePostRequest request){
        return ResponseEntity.ok(postService.createPost(request));
    }

    @PutMapping
    public ResponseEntity<PostDTO> updatePost(@RequestBody @Valid UpdatePostRequest request){
        return ResponseEntity.ok(postService.editPost(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
       Post post = postService.getPost(id);
       return ResponseEntity.ok(mapper.toDto(post));
    }
}
