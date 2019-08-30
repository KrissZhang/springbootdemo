package com.self.springbootdemo.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收器
 * @author zp
 */
@Component
public class MqReceiver {

    /**
     * queue1 队列消息接收
     * @param obj 消息内容
     */
    @RabbitHandler
    @RabbitListener(queues = "queue1", containerFactory = "pointTaskContainerFactory")
    public void queue1Receive(Object obj){
        System.out.println(obj.toString());
    }

    /**
     * queue2 队列消息接收
     * @param obj 消息内容
     */
    @RabbitHandler
    @RabbitListener(queues = "queue2", containerFactory = "pointTaskContainerFactory")
    public void queue2Receive(Object obj){
        System.out.println(obj.toString());
    }

}
