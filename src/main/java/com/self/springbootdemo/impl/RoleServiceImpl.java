package com.self.springbootdemo.impl;

import com.self.springbootdemo.constant.Constant;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.dao.mapper.RoleMapper;
import com.self.springbootdemo.entity.po.Role;
import com.self.springbootdemo.service.RoleService;
import com.self.springbootdemo.util.NumberUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色Service
 * @author zp
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper mapper;

    /**
     * 根据主键删除
     * @param integer 主键id
     * @return 删除数量
     */
    @Transactional(rollbackFor = Exception.class)
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
    public RpcClientResult insert(Role record) {
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
    public RpcClientResult insertSelective(Role record) {
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

        Role entity = mapper.selectByPrimaryKey(integer);

        if(entity == null){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        RpcClientResult<Role> result = RpcClientResult.getSuccess();
        result.setData(entity);

        return result;
    }

    /**
     * 根据对象参数更新
     * @param record 对象
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByPrimaryKeySelective(Role record) {
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
    public RpcClientResult updateByPrimaryKey(Role record) {
        if(mapper.updateByPrimaryKey(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 通过用户id查询用户角色列表
     * @param uid 用户id
     * @return 角色列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public RpcClientResult<List<Role>> selectByUid(Integer uid) {
        List<Role> list = mapper.selectByUid(uid);

        if(list != null && list.size() > 0){
            RpcClientResult result = RpcClientResult.getSuccess();
            result.setData(list);

            return result;
        }else{
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }
    }

}
