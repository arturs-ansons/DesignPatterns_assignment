package com.example.shop.factory;

import com.example.shop.dto.request.CreateProductRequest;
import com.example.shop.entity.Product;

public interface ProductFactory {
    Product create(CreateProductRequest request);
}
