package com.example.blog.services.impl;

import com.example.blog.data.models.Category;
import com.example.blog.data.repositories.CategoryRepository;
import com.example.blog.dtos.CategoryDTO;
import com.example.blog.dtos.requests.CreateCategoryRequest;
import com.example.blog.mappers.CategoryMapper;
import com.example.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Qualifier("categoryMapper")
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = repository.findAllWithPostCount();
        return categories.stream()
                .map(mapper::toCategoryDTO)
                .toList();
    }

    @Override
    public CategoryDTO createCategory(CreateCategoryRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {throw new IllegalArgumentException("Category name already exists" + request.getName()); }
        Category category = mapper.toCategory(request);
        Category savedCategory = repository.save(category);
        return mapper.toCategoryDTO(savedCategory);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()){
            if (!category.get().getPosts().isEmpty()) throw new IllegalStateException("Category has posts");
            repository.deleteById(id);
        }
    }

    @Override
    public Category findById(UUID categoryId) {
        return repository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}
