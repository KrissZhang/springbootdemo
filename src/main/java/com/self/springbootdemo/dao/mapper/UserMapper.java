package com.self.springbootdemo.dao.mapper;

import com.self.springbootdemo.entity.po.User;

import java.util.List;
import java.util.Map;

/**
 * 用户Mapper
 * @author zp
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    /**
     * 通过用户属性查询用户列表
     * @param user 用户对象
     * @return 用户列表
     */
    List<User> selectByColumn(User user);

    /**
     * 根据用户名查询角色和权限列表
     * @param userName 用户名
     * @return 角色和权限列表
     */
    List<Map<String, Object>> selectRoleAndPermissionByUserName(String userName);

}