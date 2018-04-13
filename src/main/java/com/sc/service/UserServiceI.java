package com.sc.service;



import com.sc.pojo.User;

public interface UserServiceI {

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);
}