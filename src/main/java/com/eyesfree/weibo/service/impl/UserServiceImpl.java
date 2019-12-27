package com.eyesfree.weibo.service.impl;

import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.mapper.UserMapper;
import com.eyesfree.weibo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
