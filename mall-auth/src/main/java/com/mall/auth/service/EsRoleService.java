package com.mall.auth.service;

import com.mall.auth.dao.EsRoleDao;
import com.mall.common.domain.auth.EsRole;
import com.mall.common.domain.auth.RolePermission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author HC
 * @Date 2020/6/15 16:08
 * @Version 1.0
 */
@Service
@Slf4j
public class EsRoleService {
    @Autowired
    private EsRoleDao esRoleDao;

    @Value("${admin.name}")
    private String admin;

    public int deleteByPrimaryKey(String id){
        return esRoleDao.deleteByPrimaryKey(id);
    }

    public int insertSelective(EsRole record){
        return esRoleDao.insertSelective(record);
    }

    public EsRole selectByPrimaryKey(String id){
        return esRoleDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EsRole record){
        return esRoleDao.updateByPrimaryKeySelective(record);
    }

    public List<EsRole> queryList(){
        return esRoleDao.queryList();
    }

    public int addMenu(String roleId, String[] menuIds){
        /*先清空权限*/
        esRoleDao.deleMenu(roleId);
        int flag = 0;
        /*新增权限*/
        for (String menuId : menuIds) {
            if(StringUtils.isNotEmpty(menuId)){
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(roleId);
                rolePermission.setPermissionId(menuId);
                esRoleDao.addMenu(rolePermission);
                flag++;
            }
        }
        return flag;
    }

    public List<Integer> getPermissioned(String roleId){
        List<Integer> list = esRoleDao.getPermissioned(roleId);
        return list;
    }

    public List<EsRole> getRole(String userName){
        try{
            List<EsRole> list;
            if(userName.equals(admin)){
                list = esRoleDao.getAllRole();
            }else{
                list = esRoleDao.getRole(userName);
            }
            return list;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    public List<Integer> getPermissionIds(String roleIds){
        try{
            if(StringUtils.isNotEmpty(roleIds)){
                return esRoleDao.getPermissionIds(roleIds);
            }
            return null;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }


}
