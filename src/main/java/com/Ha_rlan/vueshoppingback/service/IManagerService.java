package com.Ha_rlan.vueshoppingback.service;

import com.Ha_rlan.vueshoppingback.entity.Manager;
import com.github.pagehelper.Page;

import java.util.List;

public interface IManagerService {
    //page query
    default List<Manager> basic(Integer pageNum,Integer pageSize){
        return null;
    }
    default Page<Manager> selectByPage(Integer pageNum,Integer pageSize,String query){
        return null;
    }
    default void updateStatus(Integer id,boolean status){}
    default void addManager(Manager manager){}
    default Manager selectOne(int id){return null;}
    default void updateManager(Manager manager){}
    default void deleteManager(int id){}
    //update role
    default void addRole(int role_id,int id){}
}
