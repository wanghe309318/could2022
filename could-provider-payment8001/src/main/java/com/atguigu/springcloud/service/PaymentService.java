package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    public int add(Payment payment);

    public List<Payment> getPaymenById(@Param("id") Long id);
}
