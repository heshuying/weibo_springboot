package com.eyesfree.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eyesfree.weibo.beans.FansResponseBean;
import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.entity.Follow;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.mapper.FollowMapper;
import com.eyesfree.weibo.mapper.UserMapper;
import com.eyesfree.weibo.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
    @Autowired
    FollowMapper followMapper;
    @Autowired
    UserMapper userMapper;

    /**
     * 获取关注列表
     * @return
     */
    @Override
    public List<FollowResponseBean> getFollowList(String userId){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        return followMapper.getFollowList(map);
    }

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    @Override
    public List<FansResponseBean> getFansList(String userId){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        return followMapper.getFansList(map);
    }

    /**
     * 关注
     * @param userId
     * @param userIdFollow
     */
    @Override
    @Transactional
    public void follow(String userId, String userIdFollow){
        // 1、查询是否已关注并维护关注关系
        Follow follow = followMapper.selectOne(new QueryWrapper<Follow>().eq("user_id", userId).eq("user_id_follow", userIdFollow));
        if(follow != null && "0".equals(follow.getStatus())){
            // 已关注
            return;
        }

        if(follow != null){
            // 恢复关注
            follow.setStatus("0"); // 0 关注
            follow.setFollowTime(new Date());
            followMapper.updateById(follow);
        }else{
            // 插入关注表
            follow = new Follow();
            follow.setUserId(Integer.parseInt(userId));
            follow.setUserIdFollow(Integer.parseInt(userIdFollow));
            follow.setFollowTime(new Date());
            followMapper.insert(follow);

        }

        // 2、更新关注数和粉丝数
        User user = userMapper.selectById(userId);
        user.setFollowCount(user.getFollowCount()+1);
        userMapper.updateById(user);

        User userFollow = userMapper.selectById(userIdFollow);
        userFollow.setFansCount(userFollow.getFansCount()+1);
        userMapper.updateById(userFollow);
    }

    /**
     * 取消关注
     * @param userId
     * @param userIdFollow
     */
    @Override
    @Transactional
    public void followCancel(String userId, String userIdFollow){
        // 1、follow表中关系设为取消关注
        Follow follow = followMapper.selectOne(new QueryWrapper<Follow>().eq("user_id", userId).eq("user_id_follow", userIdFollow));
        follow.setStatus("1"); // 1 已取消
        followMapper.updateById(follow);

        // 2、更新关注数和粉丝数
        User user = userMapper.selectById(userId);
        user.setFollowCount(user.getFollowCount()-1);
        userMapper.updateById(user);

        User userFollow = userMapper.selectById(userIdFollow);
        userFollow.setFansCount(userFollow.getFansCount()-1);
        userMapper.updateById(userFollow);
    }
}
