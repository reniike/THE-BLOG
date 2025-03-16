package com.example.blog.dtos.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.lang.Long;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateCommentRequest {

    private Long commentId;

    private String comment;

    private Long postId;
}
