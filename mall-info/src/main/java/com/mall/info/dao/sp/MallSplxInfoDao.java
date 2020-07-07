package com.mall.info.dao.sp;

import com.mall.common.domain.sp.MallSplxInfo;

import java.util.List;

public interface MallSplxInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MallSplxInfo record);

    int insertSelective(MallSplxInfo record);

    MallSplxInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallSplxInfo record);

    int updateByPrimaryKey(MallSplxInfo record);

    List<MallSplxInfo> queryLxList();
}