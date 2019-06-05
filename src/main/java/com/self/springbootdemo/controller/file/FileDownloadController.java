package com.self.springbootdemo.controller.file;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件下载
 * @author zp
 */
@RestController
@RequestMapping("/file")
public class FileDownloadController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

    /**
     * 文件下载
     * @param response response
     * @param filePath 下载文件父路径(如：D:/data)
     * @param fileName 下载文件名称(如：123.txt)
     * @throws Exception 异常
     */
    @RequestMapping("/download")
    public void download(HttpServletResponse response, String filePath, String fileName) throws Exception {
        try(InputStream is = new FileInputStream(new File(filePath, fileName)); OutputStream os = response.getOutputStream()){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=" + fileName);

            //下载文件
            IOUtils.copy(is, os);
            os.flush();
        }
    }

}
