package com.example.blog.services;

import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDTO createPost(CreatePostRequest request);

    List<PostDTO> getAllPosts();

    PostDTO editPost(UpdatePostRequest request);

    void deletePost(UUID id);
}
