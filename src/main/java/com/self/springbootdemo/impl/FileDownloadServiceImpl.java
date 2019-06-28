package com.self.springbootdemo.impl;

import com.self.springbootdemo.service.FileDownloadService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件下载Service
 * @author zp
 */
@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    /**
     * 文件下载
     * @param response response
     * @param filePath 下载文件父路径(如：D:/data)
     * @param fileName 下载文件名称(如：123.txt)
     * @throws Exception 异常
     */
    @Override
    public void download(HttpServletResponse response, String filePath, String fileName) throws Exception {
        try(InputStream is = new FileInputStream(new File(filePath.trim(), fileName.trim())); OutputStream os = response.getOutputStream()){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=" + fileName);

            //下载文件
            IOUtils.copy(is, os);
            os.flush();
        }
    }

}
