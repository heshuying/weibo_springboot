package com.eyesfree.weibo.controller;


import com.eyesfree.weibo.base.R;
import com.eyesfree.weibo.beans.WeiboPublishReqBean;
import com.eyesfree.weibo.service.WeiboService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微博主表 前端控制器
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/weibo")
public class WeiboController {

    @Autowired
    WeiboService weiboService;

    @ApiOperation("发微博")
    @PostMapping("/publish")
    public R publish(@RequestBody WeiboPublishReqBean reqBean){
        weiboService.saveWeibo(reqBean);
        return R.ok();
    }
}

