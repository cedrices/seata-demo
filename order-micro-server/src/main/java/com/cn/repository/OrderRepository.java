package com.cn.repository;

import com.cn.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderRepository {

    @Insert(" insert into t_order(goods_id,account_id,amount,goods_num) values (${order.goodsId},${order.accountId},${order.amount},${order.goodsNum}) ")
    int addOrder(@Param("order") Order order);
}
