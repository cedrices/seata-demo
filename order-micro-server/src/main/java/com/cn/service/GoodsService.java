package com.cn.service;

import com.cn.domain.RespResult;
import com.cn.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "goods-micro-server")
public interface GoodsService {

    @RequestMapping(value = "/goods",method=RequestMethod.POST)
    RespResult<Goods> updateGoods(@RequestParam("id") Integer id, @RequestParam("count") Integer count);
}
