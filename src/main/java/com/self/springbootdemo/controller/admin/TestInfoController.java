package com.self.springbootdemo.controller.admin;

import com.self.springbootdemo.entity.po.TestInfo;
import com.self.springbootdemo.service.TestInfoService;
import com.self.springbootdemo.util.RpcClientResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台接口测试类
 * @author zp
 */
@Api(description = "后台接口测试类")
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
    @ApiOperation(value = "查询主键对应的TestInfo", httpMethod = "GET", notes = "查询主键对应的TestInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "主键id", defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1002, message = "参数错误")
    })
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/queryTestInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult<TestInfo> queryTestInfo(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

}
