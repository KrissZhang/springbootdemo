package com.self.springbootdemo.controller.file;

import com.self.springbootdemo.service.FileUploadService;
import com.self.springbootdemo.util.RpcClientResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author zp
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService service;

    /**
     * 文件上传
     * @param file 上传文件
     * @return 上传结果
     */
    @RequestMapping("/upload")
    public RpcClientResult upload(@RequestParam("file") MultipartFile file){
        return service.upload(file);
    }

}
