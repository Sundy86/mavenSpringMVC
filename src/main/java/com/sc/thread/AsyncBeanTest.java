package com.sc.thread;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-thread.xml"})
public class AsyncBeanTest extends AbstractTestNGSpringContextTests{

    @Resource
    AsyncBean asyncBean;

    @Test
    public void test() throws InterruptedException {
        System.out.println("你好啊");
        asyncBean.sayHello();
        System.out.println("这么久不回信息，我生气了。");
        Thread.sleep(500*1000);
    }
}
