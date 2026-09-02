package com.example.shop.dto.request;

import com.example.shop.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductRequest {

    private String name;
    private Double price;
    private Integer quantity;

    private ProductType type;

    private boolean giftWrapped;
}
