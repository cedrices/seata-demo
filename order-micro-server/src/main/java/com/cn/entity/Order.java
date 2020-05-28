package com.cn.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@Builder
public class Order {

    private Integer id;
    private Integer goodsId;
    private Integer accountId;
    private BigDecimal amount;
    private Integer goodsNum;
}
