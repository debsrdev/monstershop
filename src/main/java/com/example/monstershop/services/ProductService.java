package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductMapper;
import com.example.monstershop.dtos.product.ProductResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public List<ProductResponse> getProductById(Long productId) {
        return productRepository.findById(productId).stream()
                .map(product -> ProductMapper.entityToDto(product))
                .collect(Collectors.toList());
    }
}
