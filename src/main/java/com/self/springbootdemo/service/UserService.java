package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.util.RpcClientResult;

import java.util.List;
import java.util.Map;

/**
 * 用户Service
 * @author zp
 */
public interface UserService extends BaseService<User, Integer> {

    /**
     * 通过用户名查询唯一用户
     * @param userName 用户名
     * @return 唯一用户
     */
    RpcClientResult<User> selectByUserName(String userName);

    /**
     * 根据用户名查询角色和权限列表
     * @param userName 用户名
     * @return 角色和权限列表
     */
    RpcClientResult<List<Map<String, Object>>> selectRoleAndPermissionByUserName(String userName);

}
