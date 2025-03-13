package com.example.blog.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CommentDTO {

    private UUID id;

    private UUID postId;

    private UUID userId;

    private String comment;
}
