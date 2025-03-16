package com.example.blog.data.repositories;

import com.example.blog.data.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
