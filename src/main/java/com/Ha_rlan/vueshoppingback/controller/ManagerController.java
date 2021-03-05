package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Manager;
import com.Ha_rlan.vueshoppingback.entity.PageInfo;
import com.Ha_rlan.vueshoppingback.service.Impl.IManagerServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600L,allowCredentials = "true")
public class ManagerController {
    @Autowired
    IManagerServiceImpl iManagerService;
    @GetMapping("/Manager")
    public PageInfo<Manager> getBasic( Integer pageNum, Integer pageSize,String query){
        Page<Manager> managers = iManagerService.selectByPage(pageNum,pageSize,query);
        return new PageInfo<>(managers);
    }
    @PutMapping("updateStatus")
    public void updateStatus(Integer id,boolean state){
        iManagerService.updateStatus(id,state);
    }
    @PostMapping("addManager")
    public void addManager(@RequestBody Manager manager){
        iManagerService.addManager(manager);
    }
    @GetMapping("editManager")
    public Manager selectOne(int id) {
        return iManagerService.selectOne(id);
    }
    @PutMapping("updateManager")
    public void updateManager(@RequestBody Manager manager){iManagerService.updateManager(manager);}
    @PutMapping("deleteManager")
    public void deleteManager(int id){iManagerService.deleteManager(id);}
    @PutMapping("addRole")
    public void addRole(int role_id,int id){
        iManagerService.addRole(role_id,id);
    }
}
