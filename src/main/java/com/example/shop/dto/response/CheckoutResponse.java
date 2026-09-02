package com.example.shop.dto.response;

import com.example.shop.enums.OrderStatus;
import com.example.shop.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckoutResponse {

    private Long orderId;
    private Long customerId;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
    private boolean paid;
}