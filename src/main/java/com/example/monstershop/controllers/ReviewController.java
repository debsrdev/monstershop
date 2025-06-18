package com.example.monstershop.controllers;

import com.example.monstershop.dtos.review.ReviewRequest;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(reviewService.getReviewsByProductId(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@Valid @RequestBody ReviewRequest reviewRequest){
        ReviewResponse newReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
}
