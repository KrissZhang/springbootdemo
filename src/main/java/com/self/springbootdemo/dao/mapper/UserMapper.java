package com.self.springbootdemo.dao.mapper;

import com.self.springbootdemo.entity.po.User;

import java.util.List;

/**
 * 用户Mapper
 * @author zp
 */
public interface UserMapper extends BaseMapper<User,Integer> {

    /**
     * 用户对象列表
     * @param user 用户参数对象
     * @return 用户列表
     */
    List<User> selectByColumn(User user);

}