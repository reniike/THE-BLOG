package com.example.blog.services;

import com.example.blog.data.models.Tag;
import com.example.blog.dtos.TagDTO;

import java.util.List;

public interface TagService {

    Tag findOrCreateTag(String tagName);

    List<TagDTO> getTags();
}
