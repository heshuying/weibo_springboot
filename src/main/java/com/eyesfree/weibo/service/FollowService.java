package com.eyesfree.weibo.service;

import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface FollowService extends IService<Follow> {

    List<FollowResponseBean> getFollowList(String userId);
}
