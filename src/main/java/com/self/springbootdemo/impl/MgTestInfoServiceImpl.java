package com.self.springbootdemo.impl;

import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.entity.mgo.MgTestInfo;
import com.self.springbootdemo.service.MgTestInfoService;
import com.self.springbootdemo.util.NumberUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * MongoDb测试Service
 * @author zp
 */
@Service
public class MgTestInfoServiceImpl implements MgTestInfoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存文档
     * @param mgTestInfo 文档对象
     * @return 保存结果
     */
    @Override
    public RpcClientResult save(MgTestInfo mgTestInfo) {
        Object result = mongoTemplate.save(mgTestInfo);
        return result!=null?RpcClientResult.getSuccess():RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
    }

    /**
     * 根据主键查询文档
     * @param integer 主键id
     * @return 文档
     */
    @Override
    public RpcClientResult selectByPrimaryKey(Integer integer) {
        //校验文档id
        if(!NumberUtil.isNaturalNumber(integer)){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        //设置查询条件
        Criteria criteria = Criteria.where("_id").is(integer);
        Query query = Query.query(criteria);

        MgTestInfo mgTestInfo = mongoTemplate.findOne(query, MgTestInfo.class);

        RpcClientResult result = RpcClientResult.getSuccess();
        result.setData(mgTestInfo);

        return result;
    }

}
