package com.example.shop.controller;

import com.example.shop.dto.request.CheckoutRequest;
import com.example.shop.dto.response.CheckoutResponse;
import com.example.shop.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponse checkout(
            @RequestBody CheckoutRequest request) {

        return checkoutService.checkout(request);
    }
}