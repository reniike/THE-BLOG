package com.example.blog.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "category name is required")
    @Size(min = 2, max = 50, message = "category must be between {min} and {max} characters")
    @Pattern(regexp = "^[\\w\\s-]+$", message = "category name can only contain numbers, letters, spaces and hyphens")
    private String name;


}
