package com.eyesfree.weibo.service.impl;

import com.eyesfree.weibo.entity.Weibo;
import com.eyesfree.weibo.entity.WeiboComment;
import com.eyesfree.weibo.entity.WeiboLike;
import com.eyesfree.weibo.mapper.WeiboCommentMapper;
import com.eyesfree.weibo.mapper.WeiboMapper;
import com.eyesfree.weibo.service.WeiboCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 微博评论表 服务实现类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Service
public class WeiboCommentServiceImpl extends ServiceImpl<WeiboCommentMapper, WeiboComment> implements WeiboCommentService {
    @Autowired
    WeiboCommentMapper commentMapper;
    @Autowired
    WeiboMapper weiboMapper;

    @Override
    @Transactional
    public void saveWeiboComment(WeiboComment reqBean){
        // 1、插入评论表
        reqBean.setCommentTime(new Date());
        commentMapper.insert(reqBean);

        // 2、更新微博表评论数
        Weibo weibo = weiboMapper.selectById(reqBean.getWeiboId());
        weibo.setCommentCount(weibo.getCommentCount() + 1);
        weibo.setUpdateTime(new Date());
        weiboMapper.updateById(weibo);
    }
}
