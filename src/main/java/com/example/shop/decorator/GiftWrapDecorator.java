package com.example.shop.decorator;

import com.example.shop.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class GiftWrapDecorator implements ProductDecorator{
    @Override
    public Product decorate(Product product) {

        product.setPrice(product.getPrice() + 10);

        return product;
    }
}
