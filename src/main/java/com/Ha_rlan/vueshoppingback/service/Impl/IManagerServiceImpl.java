package com.Ha_rlan.vueshoppingback.service.Impl;

import com.Ha_rlan.vueshoppingback.entity.Manager;
import com.Ha_rlan.vueshoppingback.mapper.ManagerMapper;
import com.Ha_rlan.vueshoppingback.service.IManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IManagerServiceImpl implements IManagerService {
    @Autowired
    ManagerMapper manage;
    @Override
    public List<Manager> basic(Integer pageNum,Integer pageSize) {
        //这里拿到了所有的数据，然后应该是按需查询，并不是一次性把数据都发过来，所以设置按钮来影响参数进而取得结果
        //那么如何取数据？首先要根据查询参数来进行排序。预留一个查询参数在这。
//        然后根据pagenum 和pagesize来获取对应的数据
        PageHelper.startPage(pageNum,pageSize);
         return   manage.selectBasic();
    }

    @Override
    public Page<Manager> selectByPage(Integer pageNum,Integer pageSize,String query) {
        PageHelper.startPage(pageNum,pageSize);
        return manage.selectByPage(query);
    }

    @Override
    public void updateStatus( Integer id, boolean status) {
        //这里使用了字符串拼接，想达到一个方法修改field来实现修改单一属性
        //reform the status
        int newStatus = status ? 1 : 0;
        manage.updateOne(id,newStatus);
    }

    @Override
    public void addManager(Manager manager) {
        manage.addManager(manager);
    }

    @Override
    public Manager selectOne(int id) {
       return manage.selectById(id);
    }

    @Override
    public void updateManager(Manager manager) {
        manage.updateManager(manager);
    }

    @Override
    public void deleteManager(int id) {
        manage.deleteManager(id);
    }
}
