package com.self.springbootdemo.impl;

import com.self.springbootdemo.service.IndexService;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.stereotype.Service;

/**
 * 首页Service
 * @author zp
 */
@Service
public class IndexServiceImpl implements IndexService {

    /**
     * 测试前台请求
     * @return 请求结果
     */
    @Override
    public RpcClientResult testIndex() {
        return RpcClientResult.getSuccess();
    }

}
