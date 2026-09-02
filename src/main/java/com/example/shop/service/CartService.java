package com.example.shop.service;

import com.example.shop.dto.request.AddProductToCartRequest;
import com.example.shop.dto.response.CartResponse;
import com.example.shop.entity.Cart;
import com.example.shop.entity.Customer;
import com.example.shop.entity.Product;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CartResponse addProductToCart(AddProductToCartRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow();

        List<Product> products = productRepository.findAllById(request.getProducts());

        Cart cart = customer.getCart();

        cart.getProducts().addAll(products);

        cartRepository.save(cart);

        return new CartResponse(cart.getId(), cart.getCustomer().getId(), cart.getProducts()
                .stream()
                .map(Product::getId)
                .toList()
        );
    }

    public CartResponse getCart(Long customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow();

        Cart cart = customer.getCart();

        return new CartResponse(
                cart.getId(),
                customer.getId(),
                cart.getProducts()
                        .stream()
                        .map(Product::getId)
                        .toList()
        );
    }
}
