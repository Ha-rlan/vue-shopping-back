package com.Ha_rlan.vueshoppingback.mapper;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper<Client> {
    @Override
    int insert(Client entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int update(Client entity, Wrapper<Client> updateWrapper);

    @Override
    Client selectById(Serializable id);

    @Override
    int delete(Wrapper<Client> queryWrapper);

    @Override
    List<Client> selectList(Wrapper<Client> queryWrapper);


}
