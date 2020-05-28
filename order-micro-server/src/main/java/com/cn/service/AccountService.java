package com.cn.service;

import com.cn.domain.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-micro-server")
public interface AccountService {

    @RequestMapping(value = "/account",method = RequestMethod.POST)
    RespResult<Integer> updateAcount(@RequestParam("amount") BigDecimal amount, @RequestParam("accountId") Integer accountId);
}
