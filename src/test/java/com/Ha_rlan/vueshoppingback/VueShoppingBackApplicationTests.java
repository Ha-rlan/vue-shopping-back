package com.Ha_rlan.vueshoppingback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest
@WebAppConfiguration
class VueShoppingBackApplicationTests {
    @Resource
    private JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2564776749@qq.com");
        message.setTo("2146751042@qq.com");
        message.setSubject("测试邮件");
        message.setText("我叫你一声你敢答应吗");
        this.javaMailSender.send(message);
    }
    @Test
    void generateCode(){
        //生成10以内随机数的代码
        int[] nums = new int[6];
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = (int) Math.floor(Math.random()*10);
            nums[i] = num;
        }
//        使用for循环遍历拼接
        for (int num : nums) {
            code.append(num);
        }
        System.out.println(code.toString());
//        思考下怎么将这6个数字拼成一个字符串
//        思路一：一个一个拿出来硬拼
//        思路二：在生成的时候就转变成字符串，然后存到一个集合中，通过操作字符串进行拼接；这样还要new一个StringBuilder

    }

}
