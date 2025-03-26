package com.example.blog.services.impl;

import com.example.blog.data.models.Category;
import com.example.blog.data.models.Subscription;
import com.example.blog.data.models.User;
import com.example.blog.data.repositories.SubscriptionRepository;
import com.example.blog.dtos.SubscriptionDTO;
import com.example.blog.mappers.SubscriptionMapper;
import com.example.blog.services.CategoryService;
import com.example.blog.services.SubscriptionService;
import com.example.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;

    private final UserService userService;

    private final CategoryService categoryService;

    @Qualifier("subscriptionMapper")
    private final SubscriptionMapper mapper;

    @Override
    public SubscriptionDTO subscribe(Long categoryId) {

        User user = userService.getCurrentUser();
        Category category = categoryService.findById(categoryId);

        Subscription subscription = Subscription.builder()
                .category(category)
                .user(user)
                .build();

        repository.save(subscription);
        return mapper.toDTO(subscription);
    }
}
