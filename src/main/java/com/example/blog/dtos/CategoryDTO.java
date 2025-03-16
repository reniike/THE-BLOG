package com.example.blog.dtos;

import com.example.blog.data.models.Post;
import lombok.*;

import java.util.List;
import java.lang.Long;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private Long id;

    private String name;

    private Long postCount;
}
