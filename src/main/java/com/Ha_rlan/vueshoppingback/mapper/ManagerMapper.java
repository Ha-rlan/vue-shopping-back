package com.Ha_rlan.vueshoppingback.mapper;

import com.Ha_rlan.vueshoppingback.entity.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper extends BaseMapper {
    List<Manager> selectBasic();
    //search for portion field
    Page<Manager> selectByPage(String query);
//    update the user status
    void updateOne(int id, int status);
    void addManager(Manager manager);
    Manager selectById(int id);
    void updateManager(Manager manager);
    void deleteManager(int id);
}
