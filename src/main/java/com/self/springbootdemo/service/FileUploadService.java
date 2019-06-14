package com.self.springbootdemo.service;

import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传Service
 * @author zp
 */
public interface FileUploadService {

    /**
     * 文件上传
     * @param file 上传文件
     * @return 上传结果
     */
    RpcClientResult upload(MultipartFile file);

}
