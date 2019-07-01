package com.self.springbootdemo.impl;

import com.self.springbootdemo.service.EmailService;
import com.self.springbootdemo.util.MailUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.stereotype.Service;

/**
 * 邮件Service
 * @author zp
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param content 邮件内容
     * @param receiver 邮件接收人
     * @return 发送结果
     */
    @Override
    public RpcClientResult sendSimpleEmail(String title, String content, String receiver) {
        return MailUtil.sendSimpleEmail(title, content, receiver);
    }

}
