package com.Ha_rlan.vueshoppingback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Ha_rlan.vueshoppingback.mapper")
public class VueShoppingBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueShoppingBackApplication.class, args);
    }

}
