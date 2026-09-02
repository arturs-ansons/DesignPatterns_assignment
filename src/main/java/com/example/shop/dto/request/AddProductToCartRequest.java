package com.example.shop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddProductToCartRequest {

    private Long customerId;
    private List<Long> products;
}
