package com.cn.controller;

import com.cn.domain.RespResult;
import com.cn.entity.Goods;
import com.cn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @GetMapping("/echo")
    public String echo(@RequestParam String msg){
        return "goods_"+msg;
    }

    @PostMapping
    public RespResult<Goods>  updateGoods(@RequestParam("id") Integer id,@RequestParam("count") Integer count){
        return new RespResult<Goods>(goodsService.updateGoods(Goods.builder().id(id).count(count).build()),"Ok", HttpStatus.OK.value());
    }


}
