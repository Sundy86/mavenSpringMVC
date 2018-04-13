package com.sc.test;

import com.sc.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        User user = context.getBean(User.class);
        System.out.println(user.getCarmap());
    }
}
