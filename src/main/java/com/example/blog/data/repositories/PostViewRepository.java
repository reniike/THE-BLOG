package com.example.blog.data.repositories;

import com.example.blog.data.models.PostView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;

public interface PostViewRepository extends JpaRepository<PostView, Long> {
}
