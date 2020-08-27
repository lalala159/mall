package com.mall.mdo.jdk.order.controller;

import com.mall.common.ResponseUtil;
import com.mall.common.domain.JkglUser;
import com.mall.mdo.jdk.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseUtil<JkglUser> getPaumentByid(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
