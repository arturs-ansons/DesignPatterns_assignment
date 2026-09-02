package com.example.shop.controller;

import com.example.shop.dto.request.CreateProductRequest;
import com.example.shop.dto.response.ProductResponse;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(
            @RequestBody CreateProductRequest request) {

        return productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(
            @PathVariable Long id) {

        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {

        return productService.getProducts();
    }
}