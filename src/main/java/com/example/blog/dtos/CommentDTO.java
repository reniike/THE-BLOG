package com.example.blog.dtos;

import lombok.Getter;
import lombok.Setter;

import java.lang.Long;

@Getter
@Setter
public class CommentDTO {

    private Long id;

    private Long postId;

    private Long userId;

    private String comment;
}
