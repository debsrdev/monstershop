package com.example.monstershop.dtos.review;

public record ReviewResponse(
        String username,
        double rating,
        String body
) {
}
