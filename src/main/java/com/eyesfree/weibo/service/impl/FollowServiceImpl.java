package com.eyesfree.weibo.service.impl;

import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.entity.Follow;
import com.eyesfree.weibo.mapper.FollowMapper;
import com.eyesfree.weibo.service.FollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
