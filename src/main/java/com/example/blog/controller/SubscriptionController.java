package com.example.blog.controller;

import com.example.blog.dtos.SubscriptionDTO;
import com.example.blog.dtos.requests.SubscriptionRequest;
import com.example.blog.services.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    private ResponseEntity<SubscriptionDTO> subscribe(@RequestBody @Valid Long categoryId){
        return ResponseEntity.ok().body(subscriptionService.subscribe(categoryId));
    }
}
