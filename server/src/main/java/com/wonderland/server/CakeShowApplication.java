package com.wonderland.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication()
@MapperScan("com.wonderland.server.mapper")
public class CakeShowApplication {

    //获取容器
    public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        SpringApplication.run(CakeShowApplication.class, args);
    }


}
