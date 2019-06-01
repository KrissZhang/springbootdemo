package com.self.springbootdemo.schedule;

import cn.hutool.core.date.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author zp
 */
@Component
public class ScheduleTask {

    /**
     * 每5秒执行一次定时任务
     */
    @Scheduled(fixedRate = 5000)
    public void scheduleTask1(){
        System.out.println("现在时间：" + DateTime.now());
    }

}
