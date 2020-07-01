package com.mall.auth.dao;



import com.mall.common.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈角色Dao〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Mapper
public interface RoleDao {

    /**
     * 根据用户id查找角色列表
     * @param memberId 用户id
     * @return 角色列表
     */
    List<Role> findByMemberId(String memberId);
}
