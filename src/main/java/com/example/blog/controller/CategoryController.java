package com.example.blog.controller;

import com.example.blog.data.models.Category;
import com.example.blog.dtos.CategoryDTO;
import com.example.blog.dtos.requests.CreateCategoryRequest;
import com.example.blog.mappers.CategoryMapper;
import com.example.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @Qualifier("categoryMapper")
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok().body(service.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        return new ResponseEntity<>(service.createCategory(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable UUID id) {
        Category category = service.findById(id);
        CategoryDTO categoryDTO = mapper.toCategoryDTO(category);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") UUID id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
