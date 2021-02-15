package com.Ha_rlan.vueshoppingback.service;

import com.Ha_rlan.vueshoppingback.entity.Goods;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;

public interface IGoodsService extends IService<Goods> {
    @Override
    default boolean save(Goods entity) {
        return false;
    }

    @Override
    default boolean saveBatch(Collection<Goods> entityList) {
        return false;
    }

    @Override
    default boolean removeById(Serializable id) {
        return false;
    }

    @Override
    default boolean remove(Wrapper<Goods> queryWrapper) {
        return false;
    }

    @Override
    default boolean update(Wrapper<Goods> updateWrapper) {
        return false;
    }

    @Override
    default boolean update(Goods entity, Wrapper<Goods> updateWrapper) {
        return false;
    }
}
