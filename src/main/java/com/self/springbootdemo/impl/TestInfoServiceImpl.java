package com.self.springbootdemo.impl;

import com.self.springbootdemo.constant.Constant;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.dao.mapper.TestInfoMapper;
import com.self.springbootdemo.entity.po.TestInfo;
import com.self.springbootdemo.entity.po.TestInfoExample;
import com.self.springbootdemo.service.TestInfoService;
import com.self.springbootdemo.util.NumberUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试Service
 * @author zp
 */
@Service
public class TestInfoServiceImpl implements TestInfoService {

    @Resource
    private TestInfoMapper mapper;

    /**
     * 根据example统计数量
     * @param example example
     * @return 统计数量
     */
    @Override
    public RpcClientResult countByExample(TestInfoExample example) {
        RpcClientResult result = RpcClientResult.getSuccess();
        result.setData(mapper.countByExample(example));

        return result;
    }

    /**
     * 根据example删除
     * @param example example
     * @return 删除数量
     */
    @Override
    public RpcClientResult deleteByExample(TestInfoExample example) {
        if(mapper.deleteByExample(example) >= Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

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
    public RpcClientResult insert(TestInfo record) {
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
    public RpcClientResult insertSelective(TestInfo record) {
        if(mapper.insertSelective(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据example查询列表
     * @param example example
     * @return 列表结果
     */
    @Override
    public RpcClientResult<List<TestInfo>> selectByExample(TestInfoExample example) {
        List<TestInfo> list = mapper.selectByExample(example);
        RpcClientResult<List<TestInfo>> result = RpcClientResult.getSuccess();
        result.setData(list);

        return result;
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

        TestInfo entity = mapper.selectByPrimaryKey(integer);

        if(entity == null){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        RpcClientResult<TestInfo> result = RpcClientResult.getSuccess();
        result.setData(entity);

        return result;
    }

    /**
     * 根据example设置属性更新对象
     * @param record 对象
     * @param example example
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByExampleSelective(TestInfo record, TestInfoExample example) {
        if(mapper.updateByExampleSelective(record, example) >= Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据example更新对象
     * @param record 对象
     * @param example example
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByExample(TestInfo record, TestInfoExample example) {
        if(mapper.updateByExample(record, example) >= Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据对象参数更新
     * @param record 对象
     * @return 更新数量
     */
    @Override
    public RpcClientResult updateByPrimaryKeySelective(TestInfo record) {
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
    public RpcClientResult updateByPrimaryKey(TestInfo record) {
        if(mapper.updateByPrimaryKey(record) == Constant.Common.MYBATIS_SUCCESS){
            return RpcClientResult.getSuccess();
        }

        return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

}
