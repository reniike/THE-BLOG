package com.example.blog.services.impl;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.User;
import com.example.blog.data.repositories.PostRepository;
import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.dtos.requests.UpdatePostRequest;
import com.example.blog.mappers.PostMapper;
import com.example.blog.services.CategoryService;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final PostMapper postMapper;

    @Override
    @PreAuthorize("isAuthenticated()")
    public PostDTO createPost(CreatePostRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        User currentUser = userService.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = postMapper.toEntity(request, userService, categoryService);
        post.setAuthor(currentUser);

        if (request.getStatus() == null || !request.getStatus().equals(PostStatus.PUBLISHED)) {
            post.setStatus(PostStatus.DRAFT);
        }

        postRepository.save(post);
        return postMapper.toDto(post);
    }

    @Override
    public List<PostDTO>  getAllPosts() {
        return List.of();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public PostDTO editPost(UpdatePostRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        User currentUser = userService.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = postRepository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        
        if (!post.getAuthor().equals(currentUser)) {
            throw new SecurityException("You are not authorized to edit this post");
        }

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        postRepository.save(post);
        return postMapper.toDto(post);
    }

    @Override
    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post getPost(UUID postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }
}
