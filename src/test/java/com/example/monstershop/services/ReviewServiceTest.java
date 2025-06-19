package com.example.monstershop.services;

import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;
import com.example.monstershop.repositories.ProductRepository;
import com.example.monstershop.repositories.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewServiceTest {

    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        productRepository = mock(ProductRepository.class);
        reviewService = new ReviewService(reviewRepository, productRepository);
    }

    @Test
    void getReviewsByProductId_shouldReturnReviewResponses() {
        Product product = new Product("Monster Azul", 50, "img.jpg", 4.5, 2, false);
        product.setId(1L);

        Review review1 = new Review("Carmen", 4, "Muy chulo", product);
        Review review2 = new Review("Luis", 5, "Me encanta", product);

        when(reviewRepository.findByProductId(1L)).thenReturn(List.of(review1, review2));

        List<ReviewResponse> result = reviewService.getReviewsByProductId(1L);

        assertEquals(2, result.size());
        assertEquals("Carmen", result.get(0).username());
        assertEquals("Luis", result.get(1).username());

        verify(reviewRepository, times(1)).findByProductId(1L);
    }
}
