package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.util.RpcClientResult;

/**
 * 用户Service
 * @author zp
 */
public interface UserService extends BaseService<User, Integer> {

    /**
     * 通过用户属性查询唯一用户
     * @param username 用户名
     * @return 唯一用户
     */
    RpcClientResult<User> selectByUserName(String username);

}
