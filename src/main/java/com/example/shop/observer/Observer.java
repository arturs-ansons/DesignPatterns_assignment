package com.example.shop.observer;

import com.example.shop.dto.response.NotificationResponse;

public interface Observer {

    NotificationResponse update(String message);
}
