package com.eyesfree.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eyesfree.weibo.beans.WeiboPublishReqBean;
import com.eyesfree.weibo.entity.Weibo;
import com.eyesfree.weibo.mapper.WeiboMapper;
import com.eyesfree.weibo.service.WeiboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 微博主表 服务实现类
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Service
public class WeiboServiceImpl extends ServiceImpl<WeiboMapper, Weibo> implements WeiboService {

    @Autowired
    WeiboMapper weiboMapper;

    /**
     * 保存一条微博
     * @param reqBean
     */
    @Override
    @Transactional
    public void saveWeibo(WeiboPublishReqBean reqBean){
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(reqBean, weibo);
        weibo.setUserId(Integer.parseInt(reqBean.getUserId())); // BeanUtils.copyProperties 要类型和名字都一致才能保存
        weibo.setPublishTime(new Date());
        weiboMapper.insert(weibo);
    }
}
