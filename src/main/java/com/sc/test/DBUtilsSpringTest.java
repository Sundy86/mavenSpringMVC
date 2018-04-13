package com.sc.test;

import com.sc.bean.Users;
import com.sc.db.DBUtilsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/config/spring-source.xml"})
public class DBUtilsSpringTest extends AbstractTestNGSpringContextTests{
    @Autowired
    DBUtilsTemplate dbUtilsTemplate;

    @Test
    public void dbutilsTest(){
        System.out.println(dbUtilsTemplate);
        List<Map<String, Object>> userList = dbUtilsTemplate.find("select count(*) from myuser");
        System.out.println(userList);

        //传单个参数查询
        List<Users> user = dbUtilsTemplate.find(Users.class,"select * from myuser where userId=?",13);
        System.out.println(user);

        //使用数组，传多个参数查询
        List<Users> user2 = dbUtilsTemplate.find(Users.class,"select * from myuser where userId=? and userName=?",new Object[]{20,"2545"});
        System.out.println(user2);

        Object user3 = dbUtilsTemplate.findBy("select * from myuser","userName");
        System.out.println(user3);
    }
}
