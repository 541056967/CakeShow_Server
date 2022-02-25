package com.wonderland.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wonderland.server.mapper")
public class CakeShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakeShowApplication.class, args);
    }


}
