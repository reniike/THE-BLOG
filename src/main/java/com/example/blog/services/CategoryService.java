package com.example.blog.services;

import com.example.blog.data.models.Category;
import com.example.blog.dtos.CategoryDTO;
import com.example.blog.dtos.requests.CreateCategoryRequest;

import java.util.List;
import java.lang.Long;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO createCategory(CreateCategoryRequest request);

    void deleteCategory(Long id);

    Category findById(Long categoryId);
}
