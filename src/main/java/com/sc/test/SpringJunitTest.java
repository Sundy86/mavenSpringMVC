package com.sc.test;

import com.sc.bean.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class SpringJunitTest {
    @Autowired(required = false)
    People people;

//    @Resource(name="users")
//    User user;

    @Test
    public void test(){
        System.out.println(people);
    }
}
