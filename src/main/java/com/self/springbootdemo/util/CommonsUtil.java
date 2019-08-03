package com.self.springbootdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * 通用工具类
 * @author zp
 */
public class CommonsUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CommonsUtil.class);

    /**
     * 获取项目根目录
     * @return 项目根目录路径
     */
    public static String getProjectRootPath(){
        String rootPath = "";

        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

        return rootPath;
    }

}
