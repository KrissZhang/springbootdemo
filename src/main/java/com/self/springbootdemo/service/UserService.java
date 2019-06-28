package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.User;

/**
 * 用户Service
 * @author zp
 */
public interface UserService extends BaseService<User,Integer> {

    /**
     * 通过用户名查询用户
     * @param uname 用户名
     * @return 用户
     */
    User findUserByUName(String uname);

}
