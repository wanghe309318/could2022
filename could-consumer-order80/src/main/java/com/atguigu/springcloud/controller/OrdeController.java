package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrdeController {

//    public static final String PYMENT_URL = "http://localhost:8002";

    public static final String PYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("consumer/payment/add")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PYMENT_URL + "/payment/add", payment, CommonResult.class);

    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        log.info("ssssssssssssssssssssssssssssssssssssssssssssssss");
        return restTemplate.getForObject(PYMENT_URL + "/payment/getid/" + id, CommonResult.class);

    }

}
