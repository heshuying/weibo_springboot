package com.eyesfree.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eyesfree.weibo.base.RException;
import com.eyesfree.weibo.beans.RegistReqBean;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.mapper.UserMapper;
import com.eyesfree.weibo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eyesfree.weibo.utils.CodeGenUtil;
import com.eyesfree.weibo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 微博注册用户表 服务实现类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(){
        return userMapper.getUserList();
    }

    @Override
    public void regist(RegistReqBean registReqBean){
        // 1、校验验证码

        // 2、查询是否已经注册过
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", registReqBean.getUserName()));
        if(user != null){
            throw new RException("用户名已注册");
        }

        // 3、保存注册用户记录
        user = new User();
        String salt = ""; // CodeGenUtil.getRandomCode(6);
        user.setUserName(registReqBean.getUserName());
        user.setPassword(MD5Utils.MD5(registReqBean.getPassword()));
        user.setSalt(salt);
        user.setPhoneNum(registReqBean.getPhoneNum());
        user.setSex(null);
        user.setRegistTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }
}
