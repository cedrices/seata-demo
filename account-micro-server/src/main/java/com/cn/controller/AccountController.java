package com.cn.controller;

import com.cn.domain.RespResult;
import com.cn.entity.Account;
import com.cn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping
    public RespResult<Integer> updateAcount(@RequestParam("amount") BigDecimal amount, @RequestParam("accountId") Integer accountId){
        return new RespResult<Integer>(accountService.updateAccount(accountId,amount),"OK",HttpStatus.OK.value());
    }

}
