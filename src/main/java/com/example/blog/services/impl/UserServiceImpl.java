package com.example.blog.services.impl;

import com.example.blog.data.models.User;
import com.example.blog.data.repositories.UserRepository;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User findById(UUID authorId) {
        return userRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
