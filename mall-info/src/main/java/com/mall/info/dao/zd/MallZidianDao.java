package com.mall.info.dao.zd;

import com.mall.common.domain.TreeVO;
import com.mall.info.domain.zd.MallZidian;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface MallZidianDao {

    MallZidian getById(@NotNull Integer id);

    List<MallZidian> listByEntity(MallZidian mallZidian);

    MallZidian getByEntity(MallZidian mallZidian);

    List<MallZidian> listByIds(@NotEmpty List<Integer> list);

    int insert(@NotNull MallZidian mallZidian);

    int insertBatch(@NotEmpty List<MallZidian> list);

    int update(@NotNull MallZidian mallZidian);

    int updateByField(@NotNull @Param("where") MallZidian where, @NotNull @Param("set") MallZidian set);

    int updateBatch(@NotEmpty List<MallZidian> list);

    int deleteById(@NotNull Integer id);

    int deleteByEntity(@NotNull MallZidian mallZidian);

    int deleteByIds(@NotEmpty List<Integer> list);

    int countAll();

    int countByEntity(MallZidian mallZidian);

    List<TreeVO> getTreeList();

}