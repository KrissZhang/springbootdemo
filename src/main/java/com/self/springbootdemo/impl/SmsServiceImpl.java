package com.self.springbootdemo.impl;

import cn.hutool.json.JSONObject;
import com.self.springbootdemo.service.SmsService;
import com.self.springbootdemo.thread.ThreadPool;
import com.self.springbootdemo.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sms短信Service
 * @author zp
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private ThreadPool threadPool;

    /**
     * 发送指定模板短信
     * @param signName 短信签名名称
     * @param templateCode 短信模板码
     * @param phoneNumber 短信接收电话号码
     * @param templateParam 模板参数
     */
    @Override
    public void sendSms(String signName, String templateCode, String phoneNumber, JSONObject templateParam) {
        threadPool.taskExecutor().execute(()->{
            SmsUtil.sendSms(signName, templateCode, phoneNumber, templateParam);
        });
    }

}
