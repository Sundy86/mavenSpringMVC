package com.sc.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncBean {
    @Async
    public void sayHello() throws InterruptedException {
        Thread.sleep(3*1000);
        System.out.println("我爱你");
    }
}
