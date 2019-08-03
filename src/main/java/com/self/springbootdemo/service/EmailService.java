package com.self.springbootdemo.service;

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
     */
    void sendSimpleEmail(String title, String content, String receiver);

}
