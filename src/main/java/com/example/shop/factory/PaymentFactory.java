package com.example.shop.factory;

import com.example.shop.enums.PaymentMethod;
import com.example.shop.strategy.PaymentStrategy;

public interface PaymentFactory {

    PaymentStrategy create(PaymentMethod paymentMethod);
}
