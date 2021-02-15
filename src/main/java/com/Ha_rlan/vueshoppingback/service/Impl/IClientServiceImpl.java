package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.Ha_rlan.vueshoppingback.mapper.ClientMapper;
import com.Ha_rlan.vueshoppingback.service.IClientService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
@Service
public class IClientServiceImpl extends ServiceImpl<ClientMapper,Client> implements IClientService {

    @Autowired
    ClientMapper client;
//这边client没有拿到数据
    @Override
    public boolean save(Client entity) {
        //注册方法，传入entity，调用insert插入数据库
        //登陆验证判断逻辑，获取验证码,暂时先空在这。
        client.insert(entity);
        return true;
    }

    @Override
    public boolean saveBatch(Collection<Client> entityList) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Client> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Client> queryWrapper) {
        return false;
    }

    @Override
    public boolean updateById(Client entity) {
        return false;
    }

    @Override
    public boolean update(Wrapper<Client> updateWrapper) {
        return false;
    }

    @Override
    public boolean update(Client entity, Wrapper<Client> updateWrapper) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

}
