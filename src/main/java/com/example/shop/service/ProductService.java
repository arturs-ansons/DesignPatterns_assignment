package com.example.shop.service;

import com.example.shop.decorator.GiftWrapDecorator;
import com.example.shop.dto.request.CreateProductRequest;
import com.example.shop.dto.response.ProductResponse;
import com.example.shop.entity.Product;
import com.example.shop.factory.ProductFactory;
import com.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductFactory productFactory;

    private final GiftWrapDecorator giftWrapDecorator;

    public ProductService(ProductRepository productRepository, ProductFactory productFactory, GiftWrapDecorator giftWrapDecorator) {
        this.productRepository = productRepository;
        this.productFactory = productFactory;
        this.giftWrapDecorator = giftWrapDecorator;
    }

    public ProductResponse createProduct(CreateProductRequest request){

        Product product = productFactory.create(request);


        if (request.isGiftWrapped()) {
            giftWrapDecorator.decorate(product);
        }

        Product saved = productRepository.save(product);

        return new ProductResponse(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getQuantity(),
                saved.getType()
        );
    }

    public ProductResponse getProduct(Long id){

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getType()
        );
    }

    public List<ProductResponse> getProducts(){

        return productRepository.findAll().stream().map(product -> new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getType())).toList();
    }
}
