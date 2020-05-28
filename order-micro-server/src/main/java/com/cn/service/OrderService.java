package com.cn.service;


public  interface OrderService {

    //创建订单
    void creatOrder(Integer goodsNum,Integer goodsId,Integer accountId) throws  Exception;

}
