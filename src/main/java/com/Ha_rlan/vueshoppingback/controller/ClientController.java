package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.Ha_rlan.vueshoppingback.service.Impl.IClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/select")
    public void select(){
        List<Client> clients = iClientService.list();
        clients.forEach(
                item ->{
                    System.out.println(item);
                }
        );
    }
}
