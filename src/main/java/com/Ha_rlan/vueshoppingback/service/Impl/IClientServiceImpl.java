package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.Ha_rlan.vueshoppingback.mapper.ClientMapper;
import com.Ha_rlan.vueshoppingback.service.IClientService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

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

    @Override
    public List<Client> list() {
        //查询列表的所有信息并返回数据
       return client.selectList(new QueryWrapper<Client>());
    }
    //登陆验证

    public Client getOne(String username) {
        return client.selectByAc(username);
    }
//验证码事务生成
    @Override
    public String generateCode() {
        //这里随机六个数字吧，方法比较老土，思考下有没有其他方法简便些
        int[] nums = new int[6];
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = (int) Math.floor(Math.random()*10);
            nums[i] = num;
        }
//        使用for循环遍历拼接
        for (int num : nums) {
            code.append(num);
        }
        return code.toString();
    }
}
