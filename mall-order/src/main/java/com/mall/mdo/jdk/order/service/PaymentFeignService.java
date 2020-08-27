package com.mall.mdo.jdk.order.service;

import com.mall.common.ResponseUtil;
import com.mall.common.domain.JkglUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "mall-sys")
public interface PaymentFeignService {

    @GetMapping(value = "/getUser/getById/{id}")
    ResponseUtil<JkglUser> getPaymentById(@PathVariable("id") Long id);
}
