package com.eyesfree.weibo.service;

import com.eyesfree.weibo.entity.WeiboComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 微博评论表 服务类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
public interface WeiboCommentService extends IService<WeiboComment> {

    void saveWeiboComment(WeiboComment reqBean);
}
