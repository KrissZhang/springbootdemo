package com.self.springbootdemo.impl;

import cn.hutool.setting.dialect.Props;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.service.FileUploadService;
import com.self.springbootdemo.util.IdUtil;
import com.self.springbootdemo.util.NumberUtil;
import com.self.springbootdemo.util.RpcClientResult;
import com.self.springbootdemo.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传Service
 * @author zp
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    /**
     * 文件上传
     * @param file 上传文件
     * @return 上传结果
     */
    @Override
    @SuppressWarnings("unchecked")
    public RpcClientResult upload(MultipartFile file) {
        //校验文件是否为空
        if(file.isEmpty()){
            return RpcClientResult.getFail();
        }

        //获取文件原始名称
        String originalFileName = file.getOriginalFilename();

        //校验文件是否存在
        if(StringUtils.isBlank(originalFileName)){
            return RpcClientResult.getFail();
        }

        //获取当前时间戳
        long currentTimeMillis = System.currentTimeMillis();

        //构建上传文件名
        String fileName = currentTimeMillis + SysConstant.SYS_UNDERLINE + IdUtil.simpleUUID() + originalFileName.substring(originalFileName.lastIndexOf(SysConstant.SYS_DOT));

        //生成上传路径
        String filePath = NumberUtil.decimalDiv(currentTimeMillis, 100000000) + SysConstant.SYS_SLASH + fileName;
        File dest = new File(new Props(SysConstant.SYS_CFG_NAME).get("file.path") + filePath);

        //文件夹不存在则创建文件夹
        if(!dest.getParentFile().exists()){
            boolean mkResult = dest.getParentFile().mkdirs();
            if(!mkResult){
                return RpcClientResult.getFail();
            }
        }

        //保存文件
        try{
            file.transferTo(dest.getAbsoluteFile());
            RpcClientResult result = RpcClientResult.getSuccess();
            result.setData("/upload/" + filePath);
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return RpcClientResult.getFail();
        }
    }

}
