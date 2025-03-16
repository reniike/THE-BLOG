package com.example.blog.services.impl;

import com.example.blog.data.models.User;
import com.example.blog.data.repositories.UserRepository;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.lang.Long;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        log.info("Current user: {}", username);
        return findByEmail(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User findById(Long authorId) {
        return userRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
