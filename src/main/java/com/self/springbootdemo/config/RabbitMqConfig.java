package com.self.springbootdemo.config;

import com.self.springbootdemo.constant.MqConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 * @author zp
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 消费者数量，默认为10
     */
    public static final int DEFAULT_CONSUMER_NUM = 10;

    /**
     * 每个消费者获取最大投递数量，默认为50
     */
    public static final int DEFAULT_PREFETCH_COUNT = 50;

    /**
     * 并发消费配置
     * @param configurer simpleRabbitListenerContainerFactoryConfigurer
     * @param connectionFactory connectionFactory
     * @return simpleRabbitListenerContainerFactory
     */
    @Bean("pointTaskContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setPrefetchCount(DEFAULT_PREFETCH_COUNT);
        factory.setConcurrentConsumers(DEFAULT_CONSUMER_NUM);

        configurer.configure(factory, connectionFactory);

        return factory;
    }

    /**
     * 注入 queue1
     * @return Queue
     */
    @Bean
    public Queue queue1(){
        return new Queue(MqConstant.QUEUE_NAME_ONE);
    }

    /**
     * 注入 queue2
     * @return Queue
     */
    @Bean
    public Queue queue2(){
        return new Queue(MqConstant.QUEUE_NAME_TWO);
    }

}
