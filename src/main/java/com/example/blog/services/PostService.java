package com.example.blog.services;

import com.example.blog.data.models.Post;
import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;

import java.util.List;
import java.lang.Long;

public interface PostService {

    PostDTO createPost(CreatePostRequest request);

    List<PostDTO> getAllPosts();

    PostDTO editPost(UpdatePostRequest request);

    void deletePost(Long id);

    Post getPost(Long postId);
}
