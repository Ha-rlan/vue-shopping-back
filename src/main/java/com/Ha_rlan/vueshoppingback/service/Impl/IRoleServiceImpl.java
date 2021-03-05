package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Permission;
import com.Ha_rlan.vueshoppingback.entity.Role;
import com.Ha_rlan.vueshoppingback.mapper.PermissionMapper;
import com.Ha_rlan.vueshoppingback.mapper.RoleMapper;
import com.Ha_rlan.vueshoppingback.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.peer.ListPeer;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    IPermissionServiceImpl iPermissionService;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Role> getRoleList() {
        //角色列表
        List<Role> roles = roleMapper.selectAll();
        //所有的权限列表
        List<Permission> all = permissionMapper.selectList();
        //操作工具变量

        for (int i = 0; i <roles.size(); i++) {
            //一级权限
            //cloneAll 全局没有改变
            List<Permission> cloneAll = permissionMapper.selectList();
            List<Permission> first = getFirst(cloneAll);
            //for循环遍历获取int类型right数组
            int[] rights = getIntRoleList(roles.get(i));
            //获取权限集合,且，rights是跟all那头一一对应的，这边先对rights进行一个排序
            selectionSort(rights);
            //对两个数组进行匹配，获取权限集合对象
            match(rights,cloneAll,roles.get(i));
            //获取到了对象之后，调用方法进行子集合赋值
            //这些权限还在同一级，我们的目的是去分级而不是去在所有的权限中把它的子集拿出来。
            //添加一级权限
            roles.get(i).children.addAll(first);
            //set 去重
             LinkedHashSet<Permission> set = new LinkedHashSet<>(roles.get(i).children);
            roles.get(i).children = new ArrayList<>(set);
            //获取子列表
            //这一步会影响到之前的元素，子元素会不断的重新赋值
            //赋值操作变量
            getChild(roles.get(i).children,first);
            //重新赋值
            roles.get(i).children = first;
            //不能清空，但是下一次的first又保留了上一次的值，那我们只能新建一个
            //每次循环结束，需要重置stream处操作的集合。
            cloneAll.clear();
//            cloneAll.addAll(all);
        }
        System.out.println("=====================");
        roles.forEach(System.out::println);
        return roles;
    }
    //获取对应角色的所有权限id
    public int[] getIntRoleList(Role role){
        String[] strings = role.rights_id.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }
    //对int数组进行排序(选择排序)
    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {// 第i个和第j个比较j可以取到最后一位，所以要用j<=array.length-1
                if (array[i] > array[j]) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    //匹配集合与数组
    //这里一个个匹配自然是拿不到0的导致传回前端数据有问题
    //改进之后无法匹配到其他的0值，导致只有商品这一列
    //交换工具list集合
    List<Permission> temp = new ArrayList<>();
    public void match(int[] nums,List<Permission> list,Role role){
        temp.clear();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < list.size(); j++) {

                //匹配id，成功则加入集合
                //拿到除一级菜单之外的所有权限
                //拿到了之后逆向匹配父级并添加到所有之中
                if(nums[i] == list.get(j).id){
                    temp.add(list.get(j));
                }
            }
        }
        //temp获取到了所有的权限，单纯的去getchild会把所有的拿出来
        role.children = temp;
    }
    //获取一级权限
    //结果变量

    public List<Permission> getFirst(List<Permission> all){
        List<Permission> first_temp = new ArrayList<>();
        for (Permission permission : all) {
            if (permission.parent_id == 0) {
                first_temp.add(permission);
            }
        }
        return first_temp;
    }
    //分层
    public void getChild(List<Permission> all,List<Permission> first){
        for (Permission permission : first) {
            permission.children = new ArrayList<>();
            for (Permission value : all) {
                if (permission.id == value.parent_id) {
                    permission.children.add(value);
                }
            }
            getChild(all, permission.children);
        }
    }

    @Override
    public void deleteRight(int role_id,int right_id) {
        //结果字符串
        String result = "";
        //int 转String
        String right = Integer.toString(right_id);
        //根据role_id查询role
        Role role = roleMapper.selectById(role_id);
        //分割字符串
        String[] strings = role.rights_id.split(",");
        //数组操作工具集合
        List<String> list = Arrays.asList(strings);
        List<String> arrList = new ArrayList<>(list);
        //移除指定权限
        arrList.remove(right);
        //还原字符串形式
        for (int i = 0; i < arrList.size(); i++) {
            //字符串拼接
            result = (i == arrList.size()-1)?result+arrList.get(i):result+arrList.get(i)+",";
        }
        System.out.println(result);
        //更新数据库字段
        roleMapper.updateRight(result,role_id);
   }
//增加权限
    @Override
    public void addRight(int role_id, String rights) {
        //初始rights数据
        String rightsFirst = roleMapper.selectById(role_id).rights_id;
        rightsFirst = rightsFirst+","+rights;
        roleMapper.updateRight(rightsFirst,role_id);
    }
}
