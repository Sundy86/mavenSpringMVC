package com.sc.test;

import com.sc.impl.UserServiceImpl;
import com.sc.pojo.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MyBatisTest  extends AbstractTestNGSpringContextTests {

    @Resource
    private UserServiceImpl userService;


    @Test
    public void testinsertUser(){
        User user = new User();
        user.setUserName("bbbbb16");
        user.setPassWd("bbbbb");
        user.setAddress("龙田");
        user.setEmail("sss");
        user.setType(1);
        userService.insertUser(user);
//        User user1 = userService.getUserById(1);
//        System.out.println(user1);
    }

}
