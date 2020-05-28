package com.cn.controller;

import com.cn.domain.RespResult;
import com.cn.service.OrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping("/echo")
    public String echo(@RequestParam String msg){
        return "order_"+msg;
    }

    @PostMapping
    public RespResult creatOrder(@RequestParam("goodsNum") Integer goodsNum,@RequestParam("goodsId") Integer goodsId,@RequestParam("accountId") Integer accountId) throws Exception {
        orderService.creatOrder(goodsNum,goodsId,accountId);
        return  new RespResult("OK", HttpStatus.OK.value());
    }


}
