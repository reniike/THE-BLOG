package com.example.blog.services;

import com.example.blog.data.models.Tag;

public interface TagService {

    Tag findOrCreateTag(String tagName);
}
