package com.mall.api.dao;

import com.mall.api.domain.EsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface EsMemberDao {

    EsMember getById(@NotNull String id);

    List<EsMember> listByEntity(EsMember esMember);

    EsMember getByEntity(EsMember esMember);

    List<EsMember> listByIds(@NotEmpty List<String> list);

    int insert(@NotNull EsMember esMember);

    int insertBatch(@NotEmpty List<EsMember> list);

    int update(@NotNull EsMember esMember);

    int updateByField(@NotNull @Param("where") EsMember where, @NotNull @Param("set") EsMember set);

    int updateBatch(@NotEmpty List<EsMember> list);

    int deleteById(@NotNull String id);

    int deleteByEntity(@NotNull EsMember esMember);

    int deleteByIds(@NotEmpty List<String> list);

    int countAll();

    int countByEntity(EsMember esMember);

}