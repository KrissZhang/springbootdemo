package com.self.springbootdemo.dao.mapper;

import com.self.springbootdemo.entity.po.Role;

import java.util.List;

/**
 * 角色Mapper
 * @author zp
 */
public interface RoleMapper extends BaseMapper<Role, Integer> {

    /**
     * 通过用户id查询用户所有角色
     * @param uid 用户id
     * @return 角色列表
     */
    List<Role> selectByUid(Integer uid);

}