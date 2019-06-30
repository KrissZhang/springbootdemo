package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.service.IndexService;
import com.self.springbootdemo.util.RpcClientResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IndexService service;

    /**
     * 测试前台请求
     * @return 请求结果
     */
    @ApiOperation(value = "测试前台请求", httpMethod = "GET", notes = "测试前台请求")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功")
    })
    @RequestMapping(value = "/testIndex", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult testIndex(){
        return service.testIndex();
    }

}
