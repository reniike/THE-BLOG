package com.example.blog.dtos.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateCommentRequest {

    private UUID commentId;

    private String comment;

    private UUID postId;
}
