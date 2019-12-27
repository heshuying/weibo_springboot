package com.eyesfree.weibo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微博主表
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Weibo extends Model<Weibo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联user表id
     */
    private Integer userId;

    /**
     * 微博文字内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Integer publishTime;

    /**
     * 评论次数
     */
    private Integer commentCount;

    /**
     * 点赞次数
     */
    private Integer likeCount;

    /**
     * 转发次数
     */
    private Integer shareCount;

    /**
     * 阅读次数
     */
    private Integer readCount;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
