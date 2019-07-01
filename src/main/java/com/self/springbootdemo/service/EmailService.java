package com.self.springbootdemo.service;

import com.self.springbootdemo.util.RpcClientResult;

/**
 * 邮件Service
 * @author zp
 */
public interface EmailService {

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param content 邮件内容
     * @param receiver 邮件接收人
     * @return 发送结果
     */
    RpcClientResult sendSimpleEmail(String title, String content, String receiver);

}
