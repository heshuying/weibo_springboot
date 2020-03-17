package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.entity.WeiboComment;
import com.eyesfree.weibo.entity.WeiboLike;
import com.eyesfree.weibo.service.WeiboCommentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微博评论表 前端控制器
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Slf4j
@RestController
@RequestMapping("/weiboComment")
public class WeiboCommentController {
    @Autowired
    WeiboCommentService commentService;

    @ApiOperation("评论")
    @PostMapping("/comment")
    public R publish(@RequestBody WeiboComment reqBean){
        try {
            commentService.saveWeiboComment(reqBean);
        } catch (Exception e) {
           log.error("保存评论失败：" + e.getMessage(), e);
           return R.error("评论未成功");
        }
        return R.ok();
    }
}

