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
     * 发送指定模板验证码短信
     * @param phoneNumber 短信接收电话号码
     * @param code 验证码
     */
    public static void sendSms(String phoneNumber, String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", AliConstant.ACCESS_KEY_ID, AliConstant.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", AliConstant.SIGN_NAME);
        request.putQueryParameter("TemplateCode", AliConstant.TEMPLATE_CODE);

        //短信模板参数
        JSONObject obj = new JSONObject();
        obj.put("code", code);

        request.putQueryParameter("TemplateParam", obj.toString());

        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info(response.getData());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
