package com.example.blog.mappers;

import com.example.blog.data.models.Subscription;
import com.example.blog.dtos.SubscriptionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDTO toDTO(Subscription subscription);
}
