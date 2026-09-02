package com.example.shop.controller;

import com.example.shop.dto.response.OrderResponse;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{customerId}")
    public OrderResponse createOrder(@PathVariable Long customerId) {

        return orderService.createOrder(customerId);
    }
}
