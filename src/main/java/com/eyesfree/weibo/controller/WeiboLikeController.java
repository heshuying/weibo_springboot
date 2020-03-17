package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.beans.WeiboPublishReqBean;
import com.eyesfree.weibo.entity.WeiboLike;
import com.eyesfree.weibo.service.WeiboLikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微博点赞表 前端控制器
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/weiboLike")
public class WeiboLikeController {
    @Autowired
    WeiboLikeService weiboLikeService;

    @ApiOperation("赞")
    @PostMapping("/like")
    public R publish(@RequestBody WeiboLike reqBean){
        weiboLikeService.likeWeibo(reqBean);
        return R.ok();
    }
}

