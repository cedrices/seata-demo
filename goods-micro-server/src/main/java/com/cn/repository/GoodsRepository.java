package com.cn.repository;


import com.cn.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodsRepository {

    @Update(" update t_goods set count=#{goods.count} where id=#{goods.id} ")
    int updateGoodCount(@Param("goods") Goods goods);

    @Select(" select id,name,count,price from t_goods where id = #{id} ")
    Goods findById(@Param("id") Integer id);
}
