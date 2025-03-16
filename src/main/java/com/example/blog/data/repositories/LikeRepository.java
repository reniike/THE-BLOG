package com.example.blog.data.repositories;

import com.example.blog.data.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
