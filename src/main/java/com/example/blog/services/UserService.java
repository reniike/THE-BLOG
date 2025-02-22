package com.example.blog.services;

import com.example.blog.data.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> findByEmail(String username);

    User findById(UUID authorId);
}
