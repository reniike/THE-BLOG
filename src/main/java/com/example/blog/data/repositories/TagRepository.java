package com.example.blog.data.repositories;

import com.example.blog.data.models.Tag;
import com.example.blog.dtos.TagDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

}
