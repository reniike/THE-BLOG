package com.example.blog.dtos;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.enums.Verified;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String title;

    private String content;

    private String authorName;

    private String categoryName;

    private PostStatus status;

    private Verified verified;

    private Integer readingTime;

    private Set<String> tags;

    private LocalDateTime postedOn;

    private LocalDateTime updatedAt;
}
