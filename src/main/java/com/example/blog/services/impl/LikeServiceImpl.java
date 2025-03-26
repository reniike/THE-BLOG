package com.example.blog.services.impl;

import com.example.blog.data.models.Like;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.User;
import com.example.blog.data.repositories.LikeRepository;
import com.example.blog.services.LikeService;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final UserService userService;

    private final PostService postService;

    private final LikeRepository repository;
    private final LikeRepository likeRepository;

    @Override
    public void like(Long postId) {
        User user = userService.getCurrentUser();
        Post post = postService.getPost(postId);

        Like like = Like.builder()
                .post(post)
                .user(user)
                .build();

        repository.save(like);
    }

    @Override
    public void unlike(Long postId) {
        User user = userService.getCurrentUser();
        Post post = postService.getPost(postId);

        Like like = repository.findByUserAndPost(user, post).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Like not found"));

        likeRepository.delete(like);
    }


}
