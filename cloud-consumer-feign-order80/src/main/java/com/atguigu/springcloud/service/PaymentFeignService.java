package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value  = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/getid/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

}
