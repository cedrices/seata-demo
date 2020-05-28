package com.cn.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@Builder
@AllArgsConstructor
public class Goods {

    //主键id
    private Integer id;

    //商品名称
    private String name;

    //商品数量
    private Integer count;

    //商品单价
    private BigDecimal price;
}
