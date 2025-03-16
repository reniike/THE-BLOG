package com.example.blog.dtos.requests;

import lombok.*;

import java.lang.Long;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {

    private Long id;

    private String title;

    private String content;
}
