package com.self.springbootdemo.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载Service
 * @author zp
 */
public interface FileDownloadService {

    /**
     * 文件下载
     * @param response response
     * @param filePath 下载文件父路径(如：D:/data)
     * @param fileName 下载文件名称(如：123.txt)
     * @throws Exception 异常
     */
    void download(HttpServletResponse response, String filePath, String fileName) throws Exception;

}
