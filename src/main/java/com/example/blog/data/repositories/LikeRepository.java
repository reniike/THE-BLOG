package com.example.blog.data.repositories;

import com.example.blog.data.models.Like;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);
}
