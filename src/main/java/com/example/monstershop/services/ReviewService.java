package com.example.monstershop.services;

import com.example.monstershop.dtos.review.ReviewMapper;
import com.example.monstershop.dtos.review.ReviewRequest;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;
import com.example.monstershop.repositories.ProductRepository;
import com.example.monstershop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(review -> ReviewMapper.entityToDto(review))
                .collect(Collectors.toList());
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest) {
        Product product = productRepository.findById(reviewRequest.productId())
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));

        Review newReview = ReviewMapper.dtoToEntity(reviewRequest, product);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);
    }
}
