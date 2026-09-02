package com.example.shop.dto.response;

import com.example.shop.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private ProductType type;
}
