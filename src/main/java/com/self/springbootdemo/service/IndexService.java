package com.self.springbootdemo.service;

import com.self.springbootdemo.util.RpcClientResult;

/**
 * 首页Service
 * @author zp
 */
public interface IndexService {

    /**
     * 测试前台请求
     * @return 请求结果
     */
    RpcClientResult testIndex();

    /**
     * 测试写入缓存
     * @param cacheContent 缓存内容
     * @return 操作结果
     */
    void testPutCache(String cacheContent);

    /**
     * 测试读取缓存
     * @return 读取结果
     */
    RpcClientResult testReadCache();

}
