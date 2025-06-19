package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductRequest;
import com.example.monstershop.dtos.product.ProductResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.repositories.ProductRepository;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp(){
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void getAllProducts_shouldReturnListOfProducts() {
        Product product1 = new Product("monster 1", 80, "imageUrl1", 5, 0, false);
        Product product2 = new Product("monster 2", 90, "imageUrl2", 2, 0, true);
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<ProductResponse> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("monster 1", result.getFirst().name());
        assertEquals(90, result.get(1).price());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductById_shouldReturnOneProduct_withSameId() {
        Product product1 = new Product("monster 1", 80, "imageUrl1", 5, 0, false);
        when(productRepository.findById(0L)).thenReturn(Optional.of(product1));

        ProductResponse result = productService.getProductById(0L);

        assertEquals(product1.getName(), result.name());
    }

    @Test
    void addProduct_shouldCreateAndReturnProductResponse() {
        Product productSaved = new Product("monster 1", 80, "imageUrl1", 0, 0, false);

        when(productRepository.save(any(Product.class))).thenReturn(productSaved);

        ProductResponse result = productService.addProduct(new ProductRequest("monster 1", 80, "imageUrl", 0, 0, false));

        assertEquals("monster 1", result.name());

    }
}
