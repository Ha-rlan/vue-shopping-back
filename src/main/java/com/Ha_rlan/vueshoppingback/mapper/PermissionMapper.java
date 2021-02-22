package com.Ha_rlan.vueshoppingback.mapper;

import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper {
     List<Permission> selectList();
}
