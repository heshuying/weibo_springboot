package com.eyesfree.weibo.service.impl;

import com.eyesfree.weibo.beans.WeiboPublishReqBean;
import com.eyesfree.weibo.entity.Weibo;
import com.eyesfree.weibo.entity.WeiboLike;
import com.eyesfree.weibo.mapper.WeiboLikeMapper;
import com.eyesfree.weibo.mapper.WeiboMapper;
import com.eyesfree.weibo.service.WeiboLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 微博点赞表 服务实现类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Service
public class WeiboLikeServiceImpl extends ServiceImpl<WeiboLikeMapper, WeiboLike> implements WeiboLikeService {

    @Autowired
    WeiboLikeMapper weiboLikeMapper;
    @Autowired
    WeiboMapper weiboMapper;

    @Override
    @Transactional
    public void likeWeibo(WeiboLike reqBean){
        reqBean.setLikeTime(new Date());
        weiboLikeMapper.insert(reqBean);

        // 更新微博表赞的个数
        Weibo weibo = weiboMapper.selectById(reqBean.getWeiboId());
        weibo.setLikeCount(weibo.getLikeCount() + 1);
        weibo.setUpdateTime(new Date());
        weiboMapper.updateById(weibo);
    }
}
