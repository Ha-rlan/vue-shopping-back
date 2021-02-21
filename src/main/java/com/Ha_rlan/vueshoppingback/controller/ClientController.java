package com.Ha_rlan.vueshoppingback.controller;

import com.Ha_rlan.vueshoppingback.entity.Client;
import com.Ha_rlan.vueshoppingback.service.Impl.IClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600L, allowCredentials = "true")
public class ClientController {

    public static final String QQ_COM = "2564776749@qq.com";
    @Autowired
    private IClientServiceImpl iClientService;
    @Resource
    JavaMailSender javaMailSender;

    @RequestMapping("/register")
    public boolean register(String username, String password, String email, Client client, String check_code, HttpServletRequest request) {
        //验证结果标识
        boolean flag = false;
        client.setUsername(username);
        client.setPassword(password);
        client.setEmail(email);
        String code = (String) request.getSession().getAttribute("check_code");
        System.out.println(code);
        if(code.equals(check_code)){
            try {
                iClientService.save(client);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            flag = true;
        }
            return flag;
    }
    @PostMapping ("/login")
    public boolean select(String username,String password){
        boolean message = false;
        Client client = iClientService.getOne(username);
        if(password.equals(client.getPassword())){
            message = true;
        }
        System.out.println(message);
        return message;
    }
//    邮箱注册接口
    @RequestMapping("/mail")
    public void sendMail(String username, String email,HttpServletRequest request) {
//        验证码生成
        String code = iClientService.generateCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(QQ_COM);
        message.setTo(email);
        message.setSubject("电商管理系统注册验证");
//        暂时使用简单的验证码，后边再进行优化
        message.setText(username+",欢迎您注册电商管理系统，您的验证码是:"+code);
        this.javaMailSender.send(message);
        request.getSession().setAttribute("check_code",code);
        System.out.println((String) request.getSession().getAttribute("check_code"));
    }


}
