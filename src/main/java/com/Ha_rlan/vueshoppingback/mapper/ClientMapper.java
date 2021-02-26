package com.Ha_rlan.vueshoppingback.mapper;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper<Client> {
    Client selectByAc(String username);
//    basic information
    List<Client> selectBasic();
}
