package com.sc.controller;

import com.sc.impl.UserServiceImpl;
import com.sc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    UserServiceImpl userService;

    @RequestMapping(value = "/showUser")
    public String getUser(HttpServletRequest request, Model model){

        String  userId =  request.getParameter("id");

        if(!userId.equals("")&&userId!=null){
            System.out.println(userId+"-----------");
            User user = userService.getUserById(Integer.parseInt(userId));
            model.addAttribute("user",user);
        }
        return "showUser";
    }
}
