package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.Ha_rlan.vueshoppingback.service.Impl.IPermissionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600L,allowCredentials = "true")
public class PermissionController {
    @Autowired
    IPermissionServiceImpl iPermissionService;

    @GetMapping("/menu")
    public List<Permission> selectFirst(){
        return iPermissionService.list();
    }
}