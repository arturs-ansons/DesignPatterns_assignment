package com.example.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartResponse {

    private Long cartId;
    private Long customerId;
    private List<Long> productIds;
}