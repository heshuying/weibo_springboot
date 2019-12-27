package com.eyesfree.weibo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微博点赞表
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeiboLike extends Model<WeiboLike> {

    private static final long serialVersionUID=1L;

    private Integer id;

    /**
     * 微博表id
     */
    private Integer weiboId;

    /**
     * 点赞的用户id
     */
    private Integer userId;

    /**
     * 点赞时间
     */
    private Integer likeTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
