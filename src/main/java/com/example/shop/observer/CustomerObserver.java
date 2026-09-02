package com.example.shop.observer;

import com.example.shop.dto.response.NotificationResponse;

public class CustomerObserver implements Observer{
    @Override
    public NotificationResponse update(String message) {
        return new NotificationResponse(message);
    }
}
