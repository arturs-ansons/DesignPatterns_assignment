package com.example.shop.config;

import com.example.shop.entity.Cart;
import com.example.shop.entity.Customer;
import com.example.shop.entity.Product;
import com.example.shop.enums.ProductType;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Bean
    CommandLineRunner initData() {

        return args -> {

            // Customer
            Customer customer = new Customer();
            customer.setName("Jon");

            customer = customerRepository.save(customer);

            // Product 1
            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setPrice(1000.0);
            laptop.setQuantity(10);
            laptop.setType(ProductType.ELECTRONICS);

            productRepository.save(laptop);

            // Product 2
            Product mouse = new Product();
            mouse.setName("Mouse");
            mouse.setPrice(25.0);
            mouse.setQuantity(50);
            mouse.setType(ProductType.ELECTRONICS);

            productRepository.save(mouse);

            // Cart
            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setProducts(new ArrayList<>());

            cart = cartRepository.save(cart);

            // Link customer ↔ cart
            customer.setCart(cart);
            customerRepository.save(customer);
        };
    }
}