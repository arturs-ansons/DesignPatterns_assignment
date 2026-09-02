package com.example.shop.controller;

import com.example.shop.dto.request.AddProductToCartRequest;
import com.example.shop.dto.response.CartResponse;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public CartResponse addProductToCart(
            @RequestBody AddProductToCartRequest request) {

        return cartService.addProductToCart(request);
    }

    @GetMapping("/{customerId}")
    public CartResponse getCart(
            @PathVariable Long customerId) {

        return cartService.getCart(customerId);
    }
}