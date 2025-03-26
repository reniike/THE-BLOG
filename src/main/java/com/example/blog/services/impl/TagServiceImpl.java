package com.example.blog.services.impl;

import com.example.blog.data.models.Tag;
import com.example.blog.data.repositories.TagRepository;
import com.example.blog.dtos.TagDTO;
import com.example.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public Tag findOrCreateTag(String name) {
        return tagRepository.findByName(name)
                .orElseGet(() -> {
                    Tag tag = new Tag();
                    tag.setName(name);
                    return tagRepository.save(tag);
                });
    }

    @Override
    public List<TagDTO> getTags() {
        List<Tag> tags = tagRepository.findAll();

       return tags.stream()
                .map(tag -> new TagDTO(tag.getId(), tag.getName()))
                .toList();
    }
}
