package com.example.blog.data.repositories;

import com.example.blog.data.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    Optional<Tag> findByName(String name);

    Tag getTagByName(String name);
}
