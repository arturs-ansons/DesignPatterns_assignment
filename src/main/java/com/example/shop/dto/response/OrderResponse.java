package com.example.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderResponse {

    private Long orderId;
    private Long customerId;
    private boolean paid;
}
