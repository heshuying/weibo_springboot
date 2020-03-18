package com.eyesfree.weibo.service.impl;

import com.eyesfree.weibo.beans.RegistReqBean;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.mapper.UserMapper;
import com.eyesfree.weibo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void regist(RegistReqBean registReqBean){
        // 1、校验验证码

        // 2、查询是否已经注册过

        // 3、保存注册用户记录

    }
}
