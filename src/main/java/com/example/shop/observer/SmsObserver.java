package com.example.shop.observer;

public class SmsObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("SMS sent: " + message);
    }
}