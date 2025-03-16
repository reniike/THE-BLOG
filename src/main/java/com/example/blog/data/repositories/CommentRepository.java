package com.example.blog.data.repositories;

import com.example.blog.data.models.Comment;
import com.example.blog.dtos.CommentDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.lang.Long;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> getAllByPost_Id(Long postId, Pageable pageable);
}
