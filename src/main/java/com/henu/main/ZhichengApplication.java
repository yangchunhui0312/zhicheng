package com.henu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.henu.main.mapper")
public class ZhichengApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhichengApplication.class, args);
    }
}
