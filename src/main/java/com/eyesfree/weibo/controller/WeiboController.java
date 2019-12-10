package com.eyesfree.weibo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/weibo")
public class WeiboController {

    @RequestMapping("/home")
    String home() {
        return "Hello World!";
    }
}
