package com.Ha_rlan.vueshoppingback.mapper;

import com.Ha_rlan.vueshoppingback.entity.Goods;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Override
    int insert(Goods entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int update(Goods entity, Wrapper<Goods> updateWrapper);

    @Override
    Goods selectById(Serializable id);

    @Override
    List<Goods> selectList(Wrapper<Goods> queryWrapper);
}
