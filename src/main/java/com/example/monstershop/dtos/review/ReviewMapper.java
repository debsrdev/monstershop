package com.example.monstershop.dtos.review;

import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;

import java.util.Optional;

public class ReviewMapper {
    public static Review dtoToEntity (ReviewRequest dto, Product product) {
        return new Review(dto.username(), dto.rating(), dto.body(), product);
    }

    public static ReviewResponse entityToDto(Review review){
        return new ReviewResponse(review.getUsername(), review.getRating(), review.getBody());
    }
}
