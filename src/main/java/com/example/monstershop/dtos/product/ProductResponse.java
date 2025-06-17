package com.example.monstershop.dtos.product;

import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Review;

import java.util.List;

public record ProductResponse(
        String name,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured,
        List<ReviewResponse> reviews
) {

}
