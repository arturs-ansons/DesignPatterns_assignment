package com.example.shop.strategy;

import com.example.shop.dto.response.PaymentResponse;
import com.example.shop.entity.Order;
import com.example.shop.enums.PaymentMethod;

public class CashPayment implements PaymentStrategy{
    @Override
    public PaymentResponse pay(Order order) {
        return new PaymentResponse(PaymentMethod.CASH,true);
    }
}
