package com.eyesfree.weibo.mapper;

import com.eyesfree.weibo.beans.FollowResponseBean;
import com.eyesfree.weibo.entity.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注表 Mapper 接口
 * </p>
 *
 * @author eyesfree
 * @since 2019-12-27
 */
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {
    /**
     * 获取关注列表
     * @param map
     * @return
     */
    List<FollowResponseBean> getFollowList(Map<String,Object> map);
}
