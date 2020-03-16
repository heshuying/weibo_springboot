package com.eyesfree.weibo.service;

import com.eyesfree.weibo.beans.WeiboPublishReqBean;
import com.eyesfree.weibo.entity.Weibo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 微博主表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface WeiboService extends IService<Weibo> {

    @Transactional
    void saveWeibo(WeiboPublishReqBean reqBean);
}
