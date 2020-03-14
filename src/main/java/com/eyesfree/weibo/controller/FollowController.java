package com.eyesfree.weibo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.beans.FansResponseBean;
import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.entity.Follow;
import com.eyesfree.weibo.service.FollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @ApiOperation("粉丝列表")
    @GetMapping ("/fansList/{userId}")
    public R fansList(@PathVariable String userId){
        List<FansResponseBean> list = followService.getFansList(userId);
        return R.ok().put("data", list);
    }

    /**
     * {"userId":"","userIdFollow":""}
     * @param map
     * @return
     */
    @ApiOperation("关注")
    @PostMapping ("/follow")
    public R follow(@RequestBody Map<String,String> map){
        Integer count = followService.count(new QueryWrapper<Follow>().eq("user_id", map.get("userId")).eq("user_id_follow", map.get("userIdFollow")).eq("status", "0"));
        if(count > 0){
            return R.ok("已关注过");
        }
        followService.follow(map.get("userId"), map.get("userIdFollow"));
        return R.ok();
    }

    /**
     * {"userId":"","userIdFollow":""}
     * @param map
     * @return
     */
    @ApiOperation("取消关注")
    @PostMapping ("/followCancel")
    public R followCancel(@RequestBody Map<String,String> map){
        followService.followCancel(map.get("userId"), map.get("userIdFollow"));
        return R.ok();
    }
}

