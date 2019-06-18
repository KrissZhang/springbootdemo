package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.Role;
import com.self.springbootdemo.util.RpcClientResult;

import java.util.List;

/**
 * 角色Service
 * @author zp
 */
public interface RoleService extends BaseService<Role, Integer> {

    /**
     * 通过用户id查询用户角色列表
     * @param uid 用户id
     * @return 角色列表
     */
    RpcClientResult<List<Role>> selectByUid(Integer uid);

}
