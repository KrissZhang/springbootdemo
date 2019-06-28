package com.self.springbootdemo.impl;

import com.self.springbootdemo.constant.Constant;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.dao.mapper.UserMapper;
import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.UserService;
import com.self.springbootdemo.util.NumberUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service
 * @author zp
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    /**
     * 根据主键删除
     * @param integer 主键id
     * @return 删除数量
     */
    @Override
    public RpcClientResult deleteByPrimaryKey(Integer integer) {
        if(NumberUtil.isNaturalNumber(integer)){
            if(mapper.deleteByPrimaryKey(integer) == Constant.Common.MYBATIS_SUCCESS){
                return RpcClientResult.getSuccess();
            }
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 保存对象
     * @param record 对象
     * @return 保存数量
     */
    @Override
    public RpcClientResult insert(User record) {
        if(mapper.insert(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据对象参数保存对象
     * @param record 对象
     * @return 保存数量
     */
    @Override
    public RpcClientResult insertSelective(User record) {
        if(mapper.insertSelective(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据主键查询对象
     * @param integer 主键id
     * @return 对象
     */
    @Override
    public RpcClientResult selectByPrimaryKey(Integer integer) {
        if(!NumberUtil.isNaturalNumber(integer)){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        User entity = mapper.selectByPrimaryKey(integer);

        if(entity == null){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        RpcClientResult<User> result = RpcClientResult.getSuccess();
        result.setData(entity);

        return result;
    }

    /**
     * 根据对象参数更新
     * @param record 对象
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByPrimaryKeySelective(User record) {
        if(mapper.updateByPrimaryKeySelective(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据主键id更新对象
     * @param record 对象
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByPrimaryKey(User record) {
        if(mapper.updateByPrimaryKey(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 通过用户名查询用户
     * @param uname 用户名
     * @return 用户
     */
    @Override
    public User findUserByUName(String uname) {
        User user = new User();
        user.setUname(uname);
        List<User> list = mapper.selectByColumn(user);
        if(list != null && list.size() > 0){
            return list.get(0);
        }else{
            return new User();
        }
    }

}
