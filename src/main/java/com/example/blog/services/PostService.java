package com.example.blog.services;

import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;

import java.util.List;

public interface PostService {

    PostDTO createPost(CreatePostRequest request);

    List<PostDTO> getAllPosts();

    PostDTO editPost(UpdatePostRequest request);
}
