package com.eyesfree.weibo.mapper;

import com.eyesfree.weibo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 微博注册用户表 Mapper 接口
 * </p>
 *
 * @author eyesfree
 * @since 2020-03-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();
}
