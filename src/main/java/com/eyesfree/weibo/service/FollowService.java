package com.eyesfree.weibo.service;

import com.eyesfree.weibo.beans.FansResBean;
import com.eyesfree.weibo.beans.FollowResBean;
import com.eyesfree.weibo.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 关注表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface FollowService extends IService<Follow> {

    List<FollowResBean> getFollowList(String userId);

    List<FansResBean> getFansList(String userId);

    @Transactional
    void follow(String userId, String userIdFollow);

    @Transactional
    void followCancel(String userId, String userIdFollow);
}
