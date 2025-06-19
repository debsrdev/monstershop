package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductMapper;
import com.example.monstershop.dtos.product.ProductRequest;
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

    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        return ProductMapper.entityToDto(product);
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public ProductResponse updateProduct(ProductRequest productRequest, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setImageUrl(productRequest.imageUrl());
        product.setRating(productRequest.rating());
        product.setReviewCount(productRequest.reviewCount());
        product.setFeatured(productRequest.featured());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.entityToDto(savedProduct);
    }

    public ProductResponse deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        // mapear a DTO antes de borrar
        ProductResponse deletedProduct = ProductMapper.entityToDto(product);
        productRepository.deleteById(productId);
        return deletedProduct;
    }
}
