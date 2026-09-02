package com.example.shop.strategy;

import com.example.shop.dto.response.PaymentResponse;
import com.example.shop.entity.Order;

public interface PaymentStrategy {

    PaymentResponse pay(Order order);
}
