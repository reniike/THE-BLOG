package com.example.blog.data.repositories;

import com.example.blog.data.models.Comment;
import com.example.blog.dtos.CommentDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    CommentDTO getAllByPost_Id(UUID postId, Pageable pageable);
}
