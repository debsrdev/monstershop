package com.example.monstershop.dtos.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Username must contain min 2 and max 50 characters")
        String username,
        double rating,
        String body
) {
}
