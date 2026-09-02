package com.example.shop.service;

import com.example.shop.command.Checkout;
import com.example.shop.dto.request.CheckoutRequest;
import com.example.shop.dto.response.CheckoutResponse;
import com.example.shop.entity.Order;
import com.example.shop.enums.OrderStatus;
import com.example.shop.factory.PaymentFactory;
import com.example.shop.observer.CustomerObserver;
import com.example.shop.repository.OrderRepository;
import com.example.shop.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final OrderRepository orderRepository;
    private final PaymentFactory paymentFactory;

    public CheckoutResponse checkout(CheckoutRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getCart() == null) {
            throw new IllegalStateException("Order has no cart");
        }

        PaymentStrategy strategy = paymentFactory.create(request.getPaymentMethod());

        Checkout command = new Checkout(order, strategy);

        command.execute();

        CustomerObserver observer = new CustomerObserver();
        observer.update("Order paid successfully");

        order.setStatus(OrderStatus.PAID);

        Order saved = orderRepository.save(order);

        return new CheckoutResponse(
                saved.getId(),
                saved.getCustomer().getId(),
                request.getPaymentMethod(),
                saved.getStatus(),
                true
        );
    }
}