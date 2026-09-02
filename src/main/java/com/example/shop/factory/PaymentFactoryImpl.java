package com.example.shop.factory;

import com.example.shop.enums.PaymentMethod;
import com.example.shop.strategy.CardPayment;
import com.example.shop.strategy.CashPayment;
import com.example.shop.strategy.PayPalPayment;
import com.example.shop.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactoryImpl implements PaymentFactory{
    @Override
    public PaymentStrategy create(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case CARD -> new CardPayment();
            case CASH -> new CashPayment();
            case PAYPAL -> new PayPalPayment();
        };
    }
}
