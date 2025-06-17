package com.example.monstershop.dtos.product;

import com.example.monstershop.dtos.review.ReviewMapper;
import com.example.monstershop.dtos.review.ReviewResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.models.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto){
        return new Product(dto.name(), dto.price(), dto.imageUrl(), dto.rating(), dto.reviewCount(), dto.featured());
    }

    public static ProductResponse entityToDto(Product product){
        List<ReviewResponse> reviewDtos = product.getReviews().stream()
                .map(ReviewMapper::entityToDto)
                .toList();
        return new ProductResponse(product.getName(), product.getPrice(), product.getImageUrl(), product.getRating(), product.getReviewCount(), product.isFeatured(), reviewDtos);
    }
}
