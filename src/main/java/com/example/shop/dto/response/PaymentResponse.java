package com.example.shop.dto.response;

import com.example.shop.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {

    private PaymentMethod paymentMethod;
    private boolean paid;
}
