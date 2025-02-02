package com.example.blog.repositories;

import com.example.blog.models.PostView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostViewRepository extends JpaRepository<PostView, UUID> {
}
