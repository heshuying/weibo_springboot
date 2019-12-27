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
 * 关注表
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Follow extends Model<Follow> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    /**
     * 被关注用户id
     */
    private Integer userIdFollow;

    /**
     * 关注时间
     */
    private Integer followTime;

    /**
     * 备注名称
     */
    private String remarkName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
