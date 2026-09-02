package com.example.shop.strategy;

import com.example.shop.dto.response.PaymentResponse;
import com.example.shop.entity.Order;
import com.example.shop.enums.PaymentMethod;

public class CardPayment implements PaymentStrategy{
    @Override
    public PaymentResponse pay(Order order) {
        return new PaymentResponse(PaymentMethod.CARD,true);
    }
}
