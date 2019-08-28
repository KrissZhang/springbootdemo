package com.self.springbootdemo.service;

import com.self.springbootdemo.entity.po.MgTestInfo;
import com.self.springbootdemo.util.RpcClientResult;

/**
 * MongoDb测试Service
 * @author zp
 */
public interface MgTestInfoService {

    /**
     * 保存文档
     * @param mgTestInfo 文档对象
     * @return 保存结果
     */
    RpcClientResult save(MgTestInfo mgTestInfo);

    /**
     * 根据主键查询文档
     * @param integer 主键id
     * @return 文档
     */
    RpcClientResult selectByPrimaryKey(Integer integer);

}
