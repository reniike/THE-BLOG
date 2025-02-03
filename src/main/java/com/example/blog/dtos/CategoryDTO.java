package com.example.blog.dtos;

import com.example.blog.data.models.Post;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private String name;

    private Long postCount;
}
