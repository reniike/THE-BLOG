package com.example.blog.services.impl;

import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public PostDTO createPost(CreatePostRequest request) {
        return null;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return List.of();
    }
}
