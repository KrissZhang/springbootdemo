package com.self.springbootdemo.controller.admin;

import com.self.springbootdemo.entity.po.TestInfo;
import com.self.springbootdemo.service.TestInfoService;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台接口测试类
 * @author zp
 */
@RestController
@RequestMapping("/admin/testInfo")
public class TestInfoController {

    @Autowired
    private TestInfoService service;

    /**
     * 查询主键对应的TestInfo
     * @param id 主键id
     * @return TestInfo
     */
    @RequestMapping("/queryTestInfo")
    public RpcClientResult<TestInfo> queryTestInfo(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

}
