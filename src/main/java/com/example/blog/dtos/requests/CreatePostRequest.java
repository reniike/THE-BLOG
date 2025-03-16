package com.example.blog.dtos.requests;

import com.example.blog.data.enums.PostStatus;
import lombok.*;

import java.util.Set;
import java.lang.Long;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {

    private String title;

    private String content;

    private Long authorId;

    private Long categoryId;

    private PostStatus status;

    private Set<String> tags;
}
