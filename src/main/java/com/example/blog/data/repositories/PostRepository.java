package com.example.blog.data.repositories;

import com.example.blog.data.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;

public interface PostRepository extends JpaRepository<Post, Long> {
}
