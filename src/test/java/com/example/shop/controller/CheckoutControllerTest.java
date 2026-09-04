package com.example.shop.controller;

import com.example.shop.dto.request.CheckoutRequest;
import com.example.shop.dto.response.CheckoutResponse;
import com.example.shop.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckoutControllerTest {

    @Mock
    private CheckoutService checkoutService;

    @InjectMocks
    private CheckoutController checkoutController;

    @Test
    void shouldCheckout() {

        CheckoutRequest request = mock(CheckoutRequest.class);
        CheckoutResponse expectedResponse = mock(CheckoutResponse.class);

        when(checkoutService.checkout(request))
                .thenReturn(expectedResponse);

        CheckoutResponse result = checkoutController.checkout(request);

        assertEquals(expectedResponse, result);
        verify(checkoutService).checkout(request);
    }
}