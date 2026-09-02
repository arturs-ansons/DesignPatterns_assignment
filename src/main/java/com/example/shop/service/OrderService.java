package com.example.shop.service;

import com.example.shop.dto.response.OrderResponse;
import com.example.shop.entity.Customer;
import com.example.shop.entity.Order;
import com.example.shop.enums.OrderStatus;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderResponse createOrder(Long customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow();

        if (customer.getCart() == null ||
        customer.getCart().getProducts().isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        Order order = new Order();

        order.setCustomer(customer);
        order.setCart(customer.getCart());
        order.setStatus(OrderStatus.CREATED);


        Order saved = orderRepository.save(order);

        return new OrderResponse(
                saved.getId(),
                saved.getCustomer().getId(),
                saved.getStatus() == OrderStatus.PAID
        );
    }
}
