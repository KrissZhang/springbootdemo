package com.self.springbootdemo.controller.file;

import com.self.springbootdemo.service.FileDownloadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private FileDownloadService service;

    /**
     * 文件下载
     * @param response response
     * @param filePath 下载文件父路径(如：D:/data)
     * @param fileName 下载文件名称(如：123.txt)
     * @throws Exception 异常
     */
    @ApiOperation(value = "文件下载", httpMethod = "POST", notes = "文件下载")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "filePath", dataType = "String", required = true, value = "文件路径", defaultValue = " "),
            @ApiImplicitParam(paramType = "query", name = "fileName", dataType = "String", required = true, value = "文件名", defaultValue = " ")
    })
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestParam String filePath, @RequestParam String fileName) throws Exception {
        service.download(response, filePath, fileName);
    }

}
