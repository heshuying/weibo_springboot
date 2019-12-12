package com.eyesfree.weibo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.eyesfree.weibo.mapper")
public class WeiboApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiboApplication.class, args);
    }
}
