package com.self.springbootdemo.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程任务池
 * @author zp
 */
@Configuration
@EnableAsync
public class ThreadPool {

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadTaskPool = new ThreadPoolTaskExecutor();

        //设置核心线程数
        threadTaskPool.setCorePoolSize(10);

        //设置最大线程数
        threadTaskPool.setMaxPoolSize(15);

        //设置队列容量
        threadTaskPool.setQueueCapacity(10);

        //设置线程活跃时间为300秒
        threadTaskPool.setKeepAliveSeconds(300);

        //设置默认线程名称
        threadTaskPool.setThreadNamePrefix("thread-");

        //设置拒绝策略rejection-policy：当任务池已经达到max-size时，如何处理新任务，CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        threadTaskPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //等待所有任务执行结束后再关闭线程池
        threadTaskPool.setWaitForTasksToCompleteOnShutdown(true);

        return threadTaskPool;
    }

}
