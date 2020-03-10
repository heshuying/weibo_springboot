package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.service.FollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 关注表 前端控制器
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    FollowService followService;

    @ApiOperation("关注列表")
    @GetMapping ("/followList/{userId}")
    public R followList(@PathVariable String userId){
        List<FollowResponseBean> list = followService.getFollowList(userId);
        return R.ok().put("data", list);
    }

}

