package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.Ha_rlan.vueshoppingback.entity.Role;
import com.Ha_rlan.vueshoppingback.service.IRoleService;
import com.Ha_rlan.vueshoppingback.service.Impl.IRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600L,allowCredentials = "true")
public class RoleController {
    @Autowired
    IRoleServiceImpl iRoleService;
    @GetMapping("/Role")
    public List<Role> getRolesList(){
        return iRoleService.getRoleList();
    }
    @DeleteMapping("/deleteRight")
    public void deleteRight(int role_id,int right_id){
        iRoleService.deleteRight(role_id,right_id);
    }
    @PostMapping("/addRight")
    public void addRight(int role_id,String rights){
        iRoleService.addRight(role_id,rights);
    }
}
