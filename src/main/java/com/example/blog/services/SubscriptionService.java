package com.example.blog.services;


import com.example.blog.dtos.SubscriptionDTO;

public interface SubscriptionService {

    SubscriptionDTO subscribe(Long categoryId);
}
