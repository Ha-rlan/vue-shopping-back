package com.Ha_rlan.vueshoppingback.service;

import com.Ha_rlan.vueshoppingback.entity.Role;

import java.util.List;

public interface IRoleService {
    default List<Role> getRoleList(){return null;}
    default void deleteRight(int role_id,int right_id){}
    default void addRight(int role_id,String rights){};
}
