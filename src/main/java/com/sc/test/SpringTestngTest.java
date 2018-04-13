package com.sc.test;

import com.sc.bean.People;
import com.sc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class SpringTestngTest extends AbstractTestNGSpringContextTests{
    @Resource(name = "users")
    User user;

    @Autowired(required = false)
    People people;

    @Test
    public void test(){
        System.out.println(user);
        System.out.println(people);
    }
}
