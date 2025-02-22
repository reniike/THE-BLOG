package com.example.blog.dtos.requests;

import com.example.blog.data.enums.PostStatus;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {

    private String title;

    private String content;

    private UUID authorId;

    private UUID categoryId;

    private PostStatus status;

    private Set<String> tags;
}
