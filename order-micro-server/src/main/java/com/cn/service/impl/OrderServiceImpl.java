package com.cn.service.impl;

import com.cn.domain.RespResult;
import com.cn.entity.Goods;
import com.cn.repository.OrderRepository;
import com.cn.service.AccountService;
import com.cn.service.GoodsService;
import com.cn.service.OrderService;
import com.cn.entity.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AccountService accountService;



    @Override
    @GlobalTransactional(name = "creat-order",rollbackFor = Exception.class)
    public void  creatOrder(Integer goodsCount,Integer goodsId,Integer accountId) throws  Exception{

        log.info("修改商品表 begin，商品数量：{}，商品id{}",goodsCount,goodsId);
        RespResult<Goods> respResult = goodsService.updateGoods(goodsId,goodsCount);
        Goods goods = respResult.getData();
        BigDecimal price = goods.getPrice();
        BigDecimal totalAmount = price.multiply(new BigDecimal(goodsCount)).setScale(2,BigDecimal.ROUND_HALF_UP);

        log.info("修改账户表 购买商品需要的总金额为：{} 账户id：{}",totalAmount,accountId);
        try {
            accountService.updateAcount(totalAmount,accountId);
        }catch (Exception e){
            log.info("修改账户表异常：{}",e.toString());
            throw  e;
        }


        log.info("创建订单记录");
        orderRepository.addOrder(Order.builder().accountId(accountId).amount(totalAmount).goodsId(goods.getId()).goodsNum(goodsCount).build());

    }
}
