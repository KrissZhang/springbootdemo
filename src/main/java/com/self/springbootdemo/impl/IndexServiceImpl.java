package com.self.springbootdemo.impl;

import com.self.springbootdemo.service.IndexService;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 首页Service
 * @author zp
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private CacheManager cacheManager;

    /**
     * 测试前台请求
     * @return 请求结果
     */
    @Override
    public RpcClientResult testIndex() {
        return RpcClientResult.getSuccess();
    }

    /**
     * 测试写入缓存
     * @param cacheContent 缓存内容
     * @return 操作结果
     */
    @Override
    public void testPutCache(String cacheContent) {
        Cache cache = cacheManager.getCache("userCache");
        cache.put("cacheKey", cacheContent);
    }

    /**
     * 测试读取缓存
     * @return 读取结果
     */
    @Override
    public RpcClientResult testReadCache() {
        Cache cache = cacheManager.getCache("userCache");
        String cacheValue = cache.get("cacheKey", String.class);
        RpcClientResult result = RpcClientResult.getSuccess();
        result.setData(cacheValue);

        return result;
    }

}
