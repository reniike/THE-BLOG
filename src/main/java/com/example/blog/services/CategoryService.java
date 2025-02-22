package com.example.blog.services;

import com.example.blog.data.models.Category;
import com.example.blog.dtos.CategoryDTO;
import com.example.blog.dtos.requests.CreateCategoryRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO createCategory(CreateCategoryRequest request);

    void deleteCategory(UUID id);

    Category findById(UUID categoryId);
}
