package com.atguigu.springclopud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "ssssssssssssssssss";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "dddddddddddddddddddddd";
    }
}
