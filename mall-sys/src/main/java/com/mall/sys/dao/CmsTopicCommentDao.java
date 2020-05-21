package com.mall.sys.dao;

import com.mall.sys.domain.CmsTopicComment;

public interface CmsTopicCommentDao {
    int deleteByPrimaryKey(Long id);

    int insert(CmsTopicComment record);

    int insertSelective(CmsTopicComment record);

    CmsTopicComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsTopicComment record);

    int updateByPrimaryKey(CmsTopicComment record);
}