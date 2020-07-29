package com.mall.api.service;

import com.mall.api.dao.EsMemberDao;
import com.mall.api.domain.EsMember;

import java.util.List;

public interface EsMemberServiceI {

    EsMemberDao getEsMemberDao();

    EsMember getById(String id);

    EsMember getByEntity(EsMember esMember);

    List<EsMember> listByEntity(EsMember esMember);

    List<EsMember> listByIds(List<String> ids);

    int insert(EsMember esMember);

    int insertBatch(List<EsMember> list);

    int update(EsMember esMember);

    int updateBatch(List<EsMember> list);

    int deleteById(String id);

    int deleteByEntity(EsMember esMember);

    int deleteByIds(List<String> list);

    int countAll();

    int countByEntity(EsMember esMember);
}