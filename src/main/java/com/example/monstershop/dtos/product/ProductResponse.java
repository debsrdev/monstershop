package com.example.monstershop.dtos.product;

public record ProductResponse(
        String name,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
) {

}
