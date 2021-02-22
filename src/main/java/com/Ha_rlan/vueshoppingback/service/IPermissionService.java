package com.Ha_rlan.vueshoppingback.service;


import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

public interface IPermissionService{
    default List<Permission> list(){
        return null;
    }
}
