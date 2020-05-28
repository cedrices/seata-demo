package com.cn.service.impl;

import com.cn.entity.Goods;
import com.cn.repository.GoodsRepository;
import com.cn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods updateGoods(Goods goods) {
         Goods goods1 = goodsRepository.findById(goods.getId());
         goods1.setCount(goods1.getCount()-goods.getCount());
         goodsRepository.updateGoodCount(goods1);
        return goods1;
    }
}
