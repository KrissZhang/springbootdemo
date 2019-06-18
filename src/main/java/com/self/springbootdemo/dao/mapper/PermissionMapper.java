package com.self.springbootdemo.dao.mapper;

import com.self.springbootdemo.entity.po.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限Mapper
 * @author zp
 */
public interface PermissionMapper extends BaseMapper<Permission, Integer> {

    /**
     * 根据角色id查询权限
     * @param rids 角色id列表
     * @return 权限列表
     */
    List<Permission> selectByRoleIds(@Param("rids") List<Integer> rids);

}