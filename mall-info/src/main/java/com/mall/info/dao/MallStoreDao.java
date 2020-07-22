package com.mall.info.dao;

import com.mall.info.domain.MallStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface MallStoreDao {

    MallStore getById(@NotNull Integer id);

    List<MallStore> listByEntity(MallStore mallStore);

    MallStore getByEntity(MallStore mallStore);

    List<MallStore> listByIds(@NotEmpty List<Integer> list);

    int insert(@NotNull MallStore mallStore);

    int insertBatch(@NotEmpty List<MallStore> list);

    int update(@NotNull MallStore mallStore);

    int updateByField(@NotNull @Param("where") MallStore where, @NotNull @Param("set") MallStore set);

    int updateBatch(@NotEmpty List<MallStore> list);

    int deleteById(@NotNull Integer id);

    int deleteByEntity(@NotNull MallStore mallStore);

    int deleteByIds(@NotEmpty List<Integer> list);

    int countAll();

    int countByEntity(MallStore mallStore);

}