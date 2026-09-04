package com.example.shop.controller;

import com.example.shop.dto.request.AddProductToCartRequest;
import com.example.shop.dto.response.CartResponse;
import com.example.shop.service.CartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    @Test
    void shouldAddProductToCart() {

        AddProductToCartRequest request = mock(AddProductToCartRequest.class);
        CartResponse expectedResponse = mock(CartResponse.class);

        when(cartService.addProductToCart(request))
                .thenReturn(expectedResponse);

        CartResponse result = cartController.addProductToCart(request);

        assertEquals(expectedResponse, result);
        verify(cartService).addProductToCart(request);
    }
}