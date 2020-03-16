package com.eyesfree.weibo.beans;

import lombok.Data;

/**
 * @author eyesfree
 * 关注列表Bean对象
 */
@Data
public class FollowResBean {
    private String userId;
    private String userName;
    private String trueName;
    private String introduction;
    private String followCount;
    private String fansCount;
    private String portraitUrl;
    private String sex;

}
