package com.example.shop.entity;

import com.example.shop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Cart cart;

    private boolean paid;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
