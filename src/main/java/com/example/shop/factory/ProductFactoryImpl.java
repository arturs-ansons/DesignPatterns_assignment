package com.example.shop.factory;

import com.example.shop.dto.request.CreateProductRequest;
import com.example.shop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory{
    @Override
    public Product create(CreateProductRequest request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setType(request.getType());

        return product;
    }
}
