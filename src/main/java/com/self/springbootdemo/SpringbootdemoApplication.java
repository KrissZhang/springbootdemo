package com.self.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author zp
 */
@SpringBootApplication
@MapperScan("com.self.springbootdemo.dao")
@EnableScheduling
public class SpringbootdemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    /**
     * 启动加载方法
     * @param args args
     * @throws Exception Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动成功");
    }

}
