package com.example.blog.dtos.requests;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {

    private UUID id;

    private String title;

    private String content;
}
