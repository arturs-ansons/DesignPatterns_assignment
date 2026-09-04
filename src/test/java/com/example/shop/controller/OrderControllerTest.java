package com.example.shop.controller;

import com.example.shop.dto.response.OrderResponse;
import com.example.shop.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void shouldCreateOrder() {

        Long customerId = 1L;
        OrderResponse expectedResponse = mock(OrderResponse.class);

        when(orderService.createOrder(customerId))
                .thenReturn(expectedResponse);

        OrderResponse result = orderController.createOrder(customerId);

        assertEquals(expectedResponse, result);
        verify(orderService).createOrder(customerId);
    }
}