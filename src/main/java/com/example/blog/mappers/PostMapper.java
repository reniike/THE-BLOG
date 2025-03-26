package com.example.blog.mappers;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.enums.Verified;
import com.example.blog.data.models.Category;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.Tag;
import com.example.blog.data.models.User;
import com.example.blog.dtos.PostDTO;
import com.example.blog.dtos.requests.CreatePostRequest;
import com.example.blog.services.CategoryService;
import com.example.blog.services.TagService;
import com.example.blog.services.UserService;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.lang.Long;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {TagService.class})
public interface PostMapper {

    @Mapping(target = "authorName", source = "author.name")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "tags", qualifiedByName = "mapTags")
    @Mapping(target = "status", qualifiedByName = "status")
    PostDTO toDto(Post post);

    List<PostDTO> postListToPostDtoList(List<Post> posts);

    @Mapping(target = "verified", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "readingTime", ignore = true)
    @Mapping(target = "postedOn", ignore = true)
    @Mapping(target = "category", source = "categoryId")
    @Mapping(target = "author", source = "authorId")
    Post toEntity(CreatePostRequest request, @Context UserService userService, @Context CategoryService categoryService);

    @AfterMapping
    default void afterMapping(@MappingTarget Post post, CreatePostRequest request) {
        post.setVerified(Verified.FALSE);
        post.setUpdatedAt(LocalDateTime.now());
        post.setReadingTime(calculateReadingTime(request.getContent()));
        if (post.getPostedOn() == null) post.setPostedOn(LocalDateTime.now());
    }

    default Integer calculateReadingTime(String content) {
        if (content == null || content.isEmpty()) return 0;
        int wordCount = content.split("\\s+").length;
        return (int) Math.ceil(wordCount / 200.0);
    }

    default User mapAuthor(Long authorId, @Context UserService userService) {
        if (authorId == null) return null;
        return userService.findById(authorId);
    }

    default Category mapCategory(Long categoryId, @Context CategoryService categoryService) {
        if (categoryId == null) return null;
        return categoryService.findById(categoryId);
    }

    @Named("mapTags")
    default Set<String> mapTagsToNames(Set<Tag> tags) {
        if (tags == null || tags.isEmpty()) {
            return Collections.emptySet();
        }
        return tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());
    }

    default Set<Tag> mapNamesToTags(Set<String> tags, @Context TagService tagService) {
        if (tags == null || tags.isEmpty()) {
            return Collections.emptySet();
        }
        return tags.stream()
                .map(tagService::findOrCreateTag)
                .collect(Collectors.toSet());
    }

    @Named("status")
    default String mapStatus(PostStatus status) {
        return (status == null) ? null : status.name();
    }
}


