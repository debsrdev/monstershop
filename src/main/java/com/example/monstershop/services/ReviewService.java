package com.example.monstershop.services;

import com.example.monstershop.dtos.review.ReviewMapper;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(review -> ReviewMapper.entityToDto(review))
                .collect(Collectors.toList());
    }
}
