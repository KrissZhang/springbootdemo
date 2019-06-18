package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.Permission;

import java.util.List;

/**
 * 权限Service
 * @author zp
 */
public interface PermissionService extends BaseService<Permission, Integer> {

    /**
     * 根据角色id查询权限
     * @param rids 角色id列表
     * @return 权限列表
     */
    List<Permission> selectByRoleIds(List<Integer> rids);

}
