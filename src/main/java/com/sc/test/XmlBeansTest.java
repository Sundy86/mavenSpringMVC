package com.sc.test;

import com.sc.bean.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class XmlBeansTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
//        User user1 = (User)context.getBean("user");
//        User user2 = context.getBean(User.class);
//        System.out.println(user1==user2);
//        Car car1 = (Car) context.getBean("cartest");
//        Car car2 = (Car) context.getBean(Car.class);
//        System.out.println(car1==car2);
         People people =(People) context.getBean("people");
         System.out.println(people);

        People people1 =(People) context.getBean("people1");
        System.out.println(people1);


    }
}


