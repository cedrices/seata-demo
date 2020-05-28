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
public class Account {

    private Integer id;

    private String userName;

    private BigDecimal amount;



}
