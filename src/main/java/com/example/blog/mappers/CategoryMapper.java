package com.example.blog.mappers;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.models.Category;
import com.example.blog.data.models.Post;
import com.example.blog.dtos.CategoryDTO;
import com.example.blog.dtos.requests.CreateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDTO toCategoryDTO(Category category);

    Category toCategory(CreateCategoryRequest request);

    @Named("calculatePostCount")
    default Long calculatePostCount(List<Post> posts) {
        if (posts == null || posts.isEmpty()) {
            return 0L;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
