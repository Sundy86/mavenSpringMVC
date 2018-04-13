package com.sc.test;

import com.sc.bean.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/spring-source.xml"})
public class SpringJunitJDBCTest {
    @Resource(name = "jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Test
    public void queryCount(){
        int count = jdbcTemplate.queryForObject("select count(*) from myuser",Integer.class);
        System.out.println(count);
    }

    @Test
    public void queryString(){
        String name = jdbcTemplate.queryForObject("select userName from myuser where userId=?",String.class,50);
        System.out.println(name);
    }

    @Test
    public void queryUser(){
        Users users = jdbcTemplate.queryForObject("select * from myuser where userId=?",new UserRowMapper(),50);
        System.out.println(users);
    }

    @Test
    public void queryUserList(){
        List<Users> usersList = jdbcTemplate.query("select * from myuser ",new UserRowMapper());
        for(Users user:usersList){
            System.out.println(user);
        }

    }

    @Test
    public void add(){
        String sql = "insert into myuser (address,email,passWd,phone,type,userName) values (?,?,?,?,?,?)";
        for(int i=0;i<3;i++){
           jdbcTemplate.update(sql,"上海市宝山区杨行镇"+i,"scaa@16"+i+".com","103"+i,"15212364511"+i,2,"sc"+i);
        }
    }

    @Test
    public void update(){
        String sql = "update myuser set address=?,email=? where userId=?";
        jdbcTemplate.update(sql,"湖北武汉1","1221@136.com",50);
    }

    @Test
    public void delete(){
        String sql = "delete from myuser where userId=?";
        jdbcTemplate.update(sql,51);
    }

    class  UserRowMapper implements RowMapper<Users>{
        @Override
        public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
             Users users = new Users();
             users.setUserName(resultSet.getString("userName"));
             users.setAddress(resultSet.getString("address"));
             users.setEmail(resultSet.getString("email"));
             users.setPassWd(resultSet.getString("passWd"));
             users.setPhone(resultSet.getString("phone"));
            return users;
        }
    }
}
