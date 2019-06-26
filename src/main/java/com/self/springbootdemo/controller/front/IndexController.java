package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台接口测试类
 * @author zp
 */
@RestController
@RequestMapping("/front/index")
public class IndexController {

    /**
     * 测试前台请求
     * @return 请求结果
     */
    @RequestMapping(value = "/testIndex", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult testIndex(){
        return RpcClientResult.getSuccess();
    }

}
