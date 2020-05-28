package com.cn.service.impl;


import com.cn.entity.Account;
import com.cn.repository.AccountRepository;
import com.cn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public int updateAccount(Integer id, BigDecimal totalAmount){
        Account account = accountRepository.findById(id);
        account.setAmount(account.getAmount().subtract(totalAmount).setScale(2,BigDecimal.ROUND_HALF_UP));
        return accountRepository.updateAccount(account);
    }


}
