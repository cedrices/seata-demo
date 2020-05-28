package com.cn.service;


import com.cn.entity.Account;

import java.math.BigDecimal;

public  interface AccountService {


    //修改账户
    int updateAccount(Integer id, BigDecimal totalAmount);
}
