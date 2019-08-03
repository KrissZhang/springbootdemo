package com.self.springbootdemo.util;

import cn.hutool.json.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.self.springbootdemo.constant.AliConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sms短信工具类
 * @author zp
 */
public class SmsUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    /**
     * 发送指定模板短信
     * @param signName 短信签名名称
     * @param templateCode 短信模板码
     * @param phoneNumber 短信接收电话号码
     * @param templateParam 模板参数
     */
    public static void sendSms(String signName, String templateCode, String phoneNumber, JSONObject templateParam){
        //校验参数
        if(StringUtils.isBlank(signName) || StringUtils.isBlank(templateCode) || StringUtils.isBlank(phoneNumber) || templateParam == null){
            return;
        }

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", AliConstant.ACCESS_KEY_ID, AliConstant.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber.trim());
        request.putQueryParameter("SignName", signName.trim());
        request.putQueryParameter("TemplateCode", templateCode.trim());

        //短信模板参数
        request.putQueryParameter("TemplateParam", templateParam.toString());

        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info(response.getData());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
