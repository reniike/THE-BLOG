package com.example.blog.services;

public interface LikeService {

    void like(Long postId);

    void unlike(Long postId);
}
