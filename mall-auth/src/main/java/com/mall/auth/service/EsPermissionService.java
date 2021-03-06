package com.mall.auth.service;

import com.mall.auth.dao.EsPermissionDao;
import com.mall.auth.domain.Menu;
import com.mall.auth.domain.RouterVO;
import com.mall.common.domain.auth.EsPermission;
import com.mall.common.domain.auth.MenuVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author HC
 * @Date 2020/6/11 15:42
 * @Version 1.0
 */
@Service
@CacheConfig(cacheNames = "permission")
public class EsPermissionService {
    @Autowired
    private EsPermissionDao esPermissionDao;

    @Value("${admin.name}")
    private String admin;

    public int deleteByPrimaryKey(String id) {
        return esPermissionDao.deleteByPrimaryKey(id);
    }

    public int insert(EsPermission record) {
        return esPermissionDao.insert(record);
    }

    public int insertSelective(EsPermission record) {
        return esPermissionDao.insertSelective(record);
    }

    public EsPermission selectByPrimaryKey(String id) {
        return esPermissionDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EsPermission record) {
        return esPermissionDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EsPermission record) {
        return esPermissionDao.updateByPrimaryKey(record);
    }

    public List<Menu> getUserInfo(String userName) {
        List<EsPermission> list;
        if (userName.equals(admin)) {
            list = esPermissionDao.getMenuList();
        } else {
            list = esPermissionDao.getUserInfo(userName);
        }
        List<Menu> menuVOList = new ArrayList<>();
        for (EsPermission esPermission : list) {
            if (esPermission != null && esPermission.getParentId().equals("0")) {
                Menu menuVO = new Menu();
                menuVO.setId(esPermission.getId());
                menuVO.setKey(esPermission.getId().toString());
                menuVO.setTitle(esPermission.getPermissionName());
                menuVO.setIcon(esPermission.getIcon());
                menuVO.setPath(esPermission.getUrl());
                menuVO.setChildren(this.getSubMenu(list, menuVO));
                // 添加一级菜单数据
                menuVOList.add(menuVO);
            }
        }
        return menuVOList;
    }

    public List<MenuVO> getMenuList(String userName) {
        List<EsPermission> list;
        if (userName.equals(admin)) {
            list = esPermissionDao.getMenuList();
        } else {
            list = esPermissionDao.getUserInfo(userName);
        }
        List<MenuVO> menuVOList = new ArrayList<>();
        for (EsPermission esPermission : list) {
            if (esPermission != null && esPermission.getParentId().equals("0")) {
                MenuVO menuVO = new MenuVO();
                menuVO.setId(esPermission.getId());
                menuVO.setLabel(esPermission.getPermissionName());
                menuVO.setChildren(this.getChild(list, menuVO));
                // 添加一级菜单数据
                menuVOList.add(menuVO);
            }
        }
        return menuVOList;
    }

    /**
     * 获取子菜单
     *
     * @param lists
     * @param menuVO
     * @return
     */
    private List<MenuVO> getChild(List<EsPermission> lists, MenuVO menuVO) {
        List<MenuVO> menuVOList = new ArrayList<>();
        for (EsPermission menu0 : lists) {
            if (menuVO.getId().equals(menu0.getParentId())) {
                MenuVO menuVO0 = new MenuVO();
                menuVO0.setId(menu0.getId());
                menuVO0.setLabel(menu0.getPermissionName());
                menuVOList.add(menuVO0);
                // 添加到集合
                List<MenuVO> menuVOSet = this.getChild(lists, menuVO0);
                menuVO0.setChildren(menuVOSet);
            }
        }
        return menuVOList;
    }

    /**
     * 获取子菜单
     *
     * @param lists
     * @param menuVO
     * @return
     */
    private List<Menu> getSubMenu(List<EsPermission> lists, Menu menuVO) {
        List<Menu> menuVOList = new ArrayList<>();
        for (EsPermission menu0 : lists) {
            if (menuVO.getId().equals(menu0.getParentId())) {
                Menu menuVO0 = new Menu();
                menuVO0.setId(menu0.getId());
                menuVO0.setKey(menu0.getId().toString());
                menuVO0.setPath(menu0.getUrl());
                menuVO0.setIcon(menu0.getIcon());
                menuVO0.setTitle(menu0.getPermissionName());
                menuVOList.add(menuVO0);
                // 添加到集合
                List<Menu> menuVOSet = this.getSubMenu(lists, menuVO0);
                menuVO0.setChildren(menuVOSet);
            }
        }
        return menuVOList;
    }

    /**
     * 获取路由
     *
     * @param username
     * @return
     */
    public List<RouterVO> getRouter(String username) {
        // 1. 根据用户名查找角色

        List<RouterVO> routerVOList = new ArrayList<>();

        // 2. 通过角获取菜单
        List<EsPermission> list = esPermissionDao.getUserInfo(username);
        for (EsPermission menu : list) {
            // 目录为空
            if (StringUtils.isNotEmpty(menu.getUrl())) {
                RouterVO routerVO = new RouterVO();
                routerVO.setName(menu.getPermissionName());
                routerVO.setComponent(menu.getComponent());
                routerVO.setPath(menu.getUrl());
                // 添加一级菜单数据
                routerVOList.add(routerVO);
            }
        }
        return routerVOList;
    }

    /**
     * @Description:新增菜单
     * @return:
     * @param:
     */
    public int addMenu(EsPermission esPermission) {
        return esPermissionDao.insertSelective(esPermission);
    }

    public int deleMenu(String id) {
        return esPermissionDao.deleteByPrimaryKey(id);
    }
}
