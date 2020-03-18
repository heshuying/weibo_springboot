package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.beans.RegistReqBean;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public R testApi(){
        List<User> list = userService.getUserList();
        return R.ok().put("data", list);
    }

    @ApiOperation("注册接口")
    @RequestMapping("/regist")
    public R regist(@RequestBody RegistReqBean registReqBean){
        return R.ok();
    }

    @ApiOperation("登录接口")
    @RequestMapping("/login")
    public R login(){
        return R.ok();
    }

}

