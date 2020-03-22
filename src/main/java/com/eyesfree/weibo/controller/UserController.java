package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.base.RException;
import com.eyesfree.weibo.beans.LoginReqBean;
import com.eyesfree.weibo.beans.RegistReqBean;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.service.UserService;
import com.eyesfree.weibo.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
@Slf4j
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
        try {
            userService.regist(registReqBean);
        }catch (RException e){
            log.error("注册失败", e);
            return R.error(e.getMsg());
        }catch (Exception e){
            log.error("注册失败", e);
            return R.error("注册失败");
        }
        return R.ok();
    }

    @ApiOperation("登录接口")
    @RequestMapping("/login")
    public R login(@RequestBody LoginReqBean reqBean){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(reqBean.getUserName(), MD5Utils.MD5(reqBean.getPassword()));

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return R.error("密码错误");
        } catch (AuthenticationException e) {
            return R.error("登录失败：" + e.getMessage());
        }
        return R.ok();
    }

}

