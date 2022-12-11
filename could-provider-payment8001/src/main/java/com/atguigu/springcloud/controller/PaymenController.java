package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymenController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String sport;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/get/{id}")
    public CommonResult getPaymenById (@PathVariable("id") Long id){
       List<Payment> list = paymentService.getPaymenById(id);
    return new CommonResult(200,"查询结果s"+sport,list);

    }

    @PostMapping("/add")
    public CommonResult add (@RequestBody @Param("payment") Payment payment){
        int result = paymentService.add(payment);
        log.info("插入值",payment);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }
        else {
            return new CommonResult(443,"插入失败",null);
        }
    }
    @GetMapping("/discovery")
    public DiscoveryClient getDiscoveryClient(){
        List<String> list =  discoveryClient.getServices();
        for (String str : list){
            log.info("Servicer:"+str);
        }

        List<ServiceInstance> instanceList =  discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance serviceInstance : instanceList){
            log.info("-----"+serviceInstance.getHost()+"-----"+serviceInstance.getScheme()+"-----"+serviceInstance.getPort()+"-----"+serviceInstance.getUri());
        }
        return this.discoveryClient;


    }
    @GetMapping("/lb")
    public String getPort(){
        return sport;

    }

}
