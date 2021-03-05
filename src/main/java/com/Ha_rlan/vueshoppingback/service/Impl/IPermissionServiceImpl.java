package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.Ha_rlan.vueshoppingback.mapper.PermissionMapper;
import com.Ha_rlan.vueshoppingback.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> list() {
        //获取所有参数
        List<Permission> all = permissionMapper.selectList();
        //一级菜单
        List<Permission> first;
        //筛选出一级菜单
        first = all.stream().filter(Permission -> Permission.getLevel().equals("0")).collect(Collectors.toList());
       //遍历一级菜单获取二级菜单
        getChild(all,first);
        //这里一级菜单已经获取到了子集，现在让二级菜单也获取到子集
        //如果有四级五级呢？思考一下如何去简化。
    return first;
    }

    //递归遍历获取所有的数据
    public void getChild(List<Permission> all,List<Permission> first){
        for (int i = 0; i < first.size(); i++) {
            first.get(i).children = new ArrayList<>();
            for (int j = 0; j < all.size(); j++) {
                if(first.get(i).id == all.get(j).parent_id){
                    first.get(i).children.add(all.get(j));
                }
            }
            getChild(all,first.get(i).children);
        }
    }

    //get all rights

    @Override
    public List<Permission> allRights() {
        return permissionMapper.selectRightsList();
    }
}
