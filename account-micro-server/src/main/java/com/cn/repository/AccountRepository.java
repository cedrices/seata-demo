package com.cn.repository;

import com.cn.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountRepository {


    @Update(" update t_account set amount = #{account.amount} where  id = #{account.id} ")
    int updateAccount(@Param("account") Account account);

    @Select(" select a.id,a.amount,a.user_name  from t_account a where a.id = #{id} ")
    Account findById(@Param("id") Integer id);
}
