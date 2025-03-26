package com.example.blog.controller;

import com.example.blog.dtos.TagDTO;
import com.example.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    private ResponseEntity<List<TagDTO>> getTags(){
        return ResponseEntity.ok().body(tagService.getTags());
    }
}
