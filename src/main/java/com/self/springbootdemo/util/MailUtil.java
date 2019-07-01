package com.self.springbootdemo.util;

import cn.hutool.setting.dialect.Props;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.constant.SysConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件工具类
 * 注：发送邮箱需要开启邮箱服务(如：POP3/SMTP服务)，将授权码作为发送邮箱密码
 * @author zp
 */
public class MailUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 邮件发送服务
     */
    private static JavaMailSenderImpl javaMailSender;

    //静态初始化
    static {
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(new Props(SysConstant.SYS_CFG_NAME).get("mail.smtp").toString());
        javaMailSender.setUsername(new Props(SysConstant.SYS_CFG_NAME).get("mail.senduser").toString());
        javaMailSender.setPassword(new Props(SysConstant.SYS_CFG_NAME).get("mail.password").toString());
        javaMailSender.setDefaultEncoding(SysConstant.SYS_DEFAULT_ENCODING);

        //通过SSL协议465端口发送
        Props props = new Props();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        javaMailSender.setJavaMailProperties(props);
    }

    /**
     * 发送简单邮件
     * @param title 邮件标题
     * @param content 邮件内容
     * @param receiver 邮件接收人
     * @return 发送结果
     */
    public static RpcClientResult sendSimpleEmail(final String title, final String content, final String receiver){
        //校验邮件标题和邮件接收人
        if(StringUtils.isBlank(title) || StringUtils.isBlank(receiver)){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(new Props(SysConstant.SYS_CFG_NAME).get("mail.senduser").toString());
        mailMessage.setSubject(title);
        mailMessage.setText(content);
        mailMessage.setTo(receiver);

        try{
            //发送邮件
            javaMailSender.send(mailMessage);

            RpcClientResult result = new RpcClientResult();
            result.setSuccess(true);
            result.setCode(RespCodeMsg.EMAIL_SEND_SUCCESS.getCode());
            result.setMsg(RespCodeMsg.EMAIL_SEND_SUCCESS.getMsg());
            return result;
        }catch (Exception e){
            logger.error(e.getMessage());
            return RpcClientResult.getFail(RespCodeMsg.EMAIL_SEND_FAIL);
        }
    }

}
