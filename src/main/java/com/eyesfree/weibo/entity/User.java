package com.eyesfree.weibo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微博注册用户表
 * </p>
 *
 * @author eyesfree
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String portraitUrl;

    /**
     * 手机号码
     */
    private String phoneNum;

    /**
     * 性别：0 男，1 女
     */
    private Boolean sex;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 注册时间
     */
    private LocalDateTime registTime;

    /**
     * 登录次数
     */
    private Integer loginTimes;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 账号状态：0 正常 1 禁用
     */
    private Boolean accountStatus;

    /**
     * 个人介绍
     */
    private String introduction;

    /**
     * 关注人数
     */
    private Integer followCount;

    /**
     * 粉丝人数
     */
    private Integer fansCount;

    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
