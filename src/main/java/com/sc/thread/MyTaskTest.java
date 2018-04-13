package com.sc.thread;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-thread.xml"})
public class MyTaskTest extends AbstractTestNGSpringContextTests{

    @Test
    public void test() throws InterruptedException {

         Thread.sleep(500*1000);
    }
}
