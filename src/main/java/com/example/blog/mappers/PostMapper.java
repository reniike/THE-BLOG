package com.example.blog.mappers;

import com.example.blog.data.enums.PostStatus;
import com.example.blog.data.models.Post;
import com.example.blog.data.models.Tag;
import com.example.blog.dtos.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "authorName", source = "author.name")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "tags", qualifiedByName = "tagNames")
    @Mapping(target = "status", qualifiedByName = "status")
    PostDTO toDto(Post post);

    @Named("tagNames")
    default Set<String> mapTags(Set<Tag> tags) {
        if (tags == null) {return null;}
        return tags.stream().map(Tag::getName).collect(Collectors.toSet());
    }

    @Named("status")
    default String mapStatus(PostStatus status) {
        if (status == null) {return null;}
        return status.name();
    }

}
