package com.sc.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-thread.xml"})
public class ThreadTest {

    @Autowired
    ThreadPoolTaskExecutor executor;

    @Test
    public void testGetUserById() {
        System.out.println(executor);
        for(int i=0;i<=20;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());

                }
            });
        }
    }
}
