package com.example.shop.command;

import com.example.shop.dto.response.PaymentResponse;
import com.example.shop.entity.Order;
import com.example.shop.strategy.PaymentStrategy;

public class Checkout implements Command<PaymentResponse> {

    private final Order order;
    private final PaymentStrategy paymentStrategy;

    public Checkout(Order order, PaymentStrategy paymentStrategy) {
        this.order = order;
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public PaymentResponse execute() {
        return paymentStrategy.pay(order);
    }
}