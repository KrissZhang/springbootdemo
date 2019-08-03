package com.self.springbootdemo.service;

import cn.hutool.json.JSONObject;

/**
 * Sms短信Service
 * @author zp
 */
public interface SmsService {

    /**
     * 发送指定模板短信
     * @param signName 短信签名名称
     * @param templateCode 短信模板码
     * @param phoneNumber 短信接收电话号码
     * @param templateParam 模板参数
     */
    void sendSms(String signName, String templateCode, String phoneNumber, JSONObject templateParam);

}
