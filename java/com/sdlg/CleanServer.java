package com.sdlg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication//标识主启动程序

@MapperScan("com.sdlg.mapper")
@EnableScheduling//定时任务注解
public class CleanServer {
    public static void main(String[] args) {
        SpringApplication.run(CleanServer.class,args);
    }
}