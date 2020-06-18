package com.mall.auth.service;

import com.mall.auth.dao.EsRoleDao;
import com.mall.common.domain.auth.EsRole;
import com.mall.common.domain.auth.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/15 16:08
 * @Version 1.0
 */
@Service
public class EsRoleService {
    @Autowired
    private EsRoleDao esRoleDao;

    public int deleteByPrimaryKey(Integer id){
        return esRoleDao.deleteByPrimaryKey(id);
    }

    public int insertSelective(EsRole record){
        return esRoleDao.insertSelective(record);
    }

    public EsRole selectByPrimaryKey(Integer id){
        return esRoleDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EsRole record){
        return esRoleDao.updateByPrimaryKeySelective(record);
    }

    public List<EsRole> queryList(){
        return esRoleDao.queryList();
    }

    public int addMenu(Integer roleId, String[] menuIds){
        /*先清空权限*/
        esRoleDao.deleMenu(roleId);
        int flag = 0;
        /*新增权限*/
        for (String menuId : menuIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(Integer.parseInt(menuId));
            esRoleDao.addMenu(rolePermission);
            flag++;
        }
        return flag;
    }


}
