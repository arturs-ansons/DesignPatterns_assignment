package com.example.shop.dto.request;


import com.example.shop.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutRequest {

    private Long orderId;
    private PaymentMethod paymentMethod;

}