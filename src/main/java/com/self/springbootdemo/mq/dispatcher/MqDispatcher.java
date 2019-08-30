package com.self.springbootdemo.mq.dispatcher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息分发器
 * @author zp
 */
@Service
public class MqDispatcher {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 分发消息到指定队列
     * @param queueName 队列名称
     * @param obj 消息内容
     */
    public void dispatchMsg(String queueName, Object obj){
        rabbitTemplate.convertAndSend(queueName, obj);
    }

}
