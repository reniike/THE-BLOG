package com.example.blog.services;

import com.example.blog.data.models.User;

import java.util.Optional;
import java.lang.Long;

public interface UserService {

    User getCurrentUser();

    Optional<User> findByEmail(String username);

    User findById(Long authorId);
}
