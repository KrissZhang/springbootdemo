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

}
