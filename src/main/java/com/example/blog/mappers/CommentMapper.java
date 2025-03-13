package com.example.blog.mappers;

import com.example.blog.data.models.Comment;
import com.example.blog.dtos.CommentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toDto(Comment comment);
}
