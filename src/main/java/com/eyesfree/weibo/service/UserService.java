package com.eyesfree.weibo.service;

import com.eyesfree.weibo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 微博注册用户表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface UserService extends IService<User> {

    List<User> getUserList();
}
