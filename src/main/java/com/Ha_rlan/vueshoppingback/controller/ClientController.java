package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.Ha_rlan.vueshoppingback.service.Impl.IClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private IClientServiceImpl iClientService;

    @PostMapping ("/register")
    public void register(Client client,String account,String password,String phone){
        client.setAccount(account);
        client.setPassword(password);
        client.setPhone(phone);
        iClientService.save(client);
        //这边参数进来了还是会显示报错，要么是sql语句有问题，导致连接不到数据库
    }
    @PostMapping("/test")
    //数据传参没有问题
    public void test(String message){
        System.out.println(message);
    }
    @GetMapping("/select")
    public void select(){

    }
}
