package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 微博注册用户表 前端控制器
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Api(value = "用户相关接口", tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("测试接口")
    @RequestMapping("/hello")
    public List<User> testApi(){
        return userService.list();
    }

}

