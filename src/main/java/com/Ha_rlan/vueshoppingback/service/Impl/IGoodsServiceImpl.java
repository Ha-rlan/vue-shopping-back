package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Goods;
import com.Ha_rlan.vueshoppingback.mapper.GoodsMapper;
import com.Ha_rlan.vueshoppingback.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;
import java.util.Collection;

public class IGoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Override
    public boolean save(Goods entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Goods> entityList) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Goods> queryWrapper) {
        return false;
    }

    @Override
    public boolean update(Wrapper<Goods> updateWrapper) {
        return false;
    }

    @Override
    public boolean update(Goods entity, Wrapper<Goods> updateWrapper) {
        return false;
    }
}
