package com.self.springbootdemo.impl;

import com.self.springbootdemo.service.EmailService;
import com.self.springbootdemo.thread.ThreadPool;
import com.self.springbootdemo.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 邮件Service
 * @author zp
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private ThreadPool threadPool;

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param content 邮件内容
     * @param receiver 邮件接收人
     */
    @Override
    public void sendSimpleEmail(String title, String content, String receiver) {
        threadPool.taskExecutor().execute(()->{
            MailUtil.sendSimpleEmail(title, content, receiver);
        });
    }

}
