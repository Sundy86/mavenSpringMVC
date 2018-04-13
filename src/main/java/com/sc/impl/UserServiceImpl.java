package com.sc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sc.dao.UserMapper;
import com.sc.pojo.User;
import com.sc.service.UserServiceI;

/**
 * @author gacl
 * 使用@Service注解将UserServiceImpl类标注为一个service
 * service的id是userService
 */
@Service
public class UserServiceImpl implements UserServiceI {

    /**
     * 使用@Autowired注解标注userMapper变量，
     * 当需要使用UserMapper时，Spring就会自动注入UserMapper
     */
    @Autowired
    private UserMapper userMapper;//注入dao
    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
        throw new RuntimeException("test");//抛出unchecked异常，触发事物，回滚
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}