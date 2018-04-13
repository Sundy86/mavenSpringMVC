package com.sc.thread;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;


/*
*
* 此方法无需调用，加入spring中后，程序运行后会自动加载定时任务
* */
@Component
public class MyTask {

     @Scheduled(cron = "0/5 * * * * ?")
    public void say(){
        System.out.println("这是一个say方法.....");
    }
     @Scheduled(cron = "0/5 * * * * ?")
    public void hear(){
        System.out.println("这是一个hear方法.....");
    }
}
