package com.eyesfree.weibo.service;

import com.eyesfree.weibo.entity.WeiboLike;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 微博点赞表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface WeiboLikeService extends IService<WeiboLike> {

    @Transactional
    void likeWeibo(WeiboLike reqBean);
}
