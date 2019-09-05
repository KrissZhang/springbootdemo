package com.self.springbootdemo.schedule;

import cn.hutool.core.date.DateTime;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 * @author zp
 */
@Service
public class ScheduleTask {

    /**
     * 定时任务业务逻辑
     */
    public void scheduleTask1(){
        System.out.println("现在时间：" + DateTime.now());
    }

}
