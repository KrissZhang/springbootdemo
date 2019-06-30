package com.self.springbootdemo.controller.file;

import com.self.springbootdemo.service.FileUploadService;
import com.self.springbootdemo.util.RpcClientResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author zp
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadService service;

    /**
     * 文件上传
     * @param file 上传文件
     * @return 上传结果
     */
    @ApiOperation(value = "文件上传", httpMethod = "POST", notes = "文件上传")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败")
    })
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult upload(@RequestParam("file") MultipartFile file){
        return service.upload(file);
    }

}
