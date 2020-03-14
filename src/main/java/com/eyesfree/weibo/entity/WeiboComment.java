package com.eyesfree.weibo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微博评论表
 * </p>
 *
 * @author eyesfree
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeiboComment extends Model<WeiboComment> {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer weiboId;

    /**
     * 评论人id
     */
    private Integer userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private LocalDateTime commentTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
