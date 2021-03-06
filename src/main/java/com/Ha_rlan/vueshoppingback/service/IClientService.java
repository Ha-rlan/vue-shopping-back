package com.Ha_rlan.vueshoppingback.service;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;


import java.io.Serializable;
import java.util.Collection;
import java.util.Map;


public interface IClientService extends IService<Client> {

    @Override
    default boolean save(Client entity) {
        return false;
    }

    @Override
    default boolean saveBatch(Collection<Client> entityList) {
        return false;
    }

    @Override
    boolean saveBatch(Collection<Client> entityList, int batchSize);

    @Override
    default boolean removeById(Serializable id) {
        return false;
    }

    @Override
    default boolean remove(Wrapper<Client> queryWrapper) {
        return false;
    }

    @Override
    default boolean updateById(Client entity) {
        return false;
    }

    @Override
    default boolean update(Wrapper<Client> updateWrapper) {
        return false;
    }

    @Override
    default boolean update(Client entity, Wrapper<Client> updateWrapper) {
        return false;
    }

    @Override
    default boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    default boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }
}
