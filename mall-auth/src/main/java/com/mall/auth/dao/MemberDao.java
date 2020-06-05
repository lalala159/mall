package com.mall.auth.dao;


import com.mall.common.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈用户Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Mapper
public interface MemberDao {

    /**
     * 根据会员名查找会员
     * @param memberName 会员名
     * @return 会员
     */
    Member findByMemberName(String memberName);

    List<Member> queryList(@Param(value = "memberName") String memberName, @Param(value = "mobile") String mobile);
}
