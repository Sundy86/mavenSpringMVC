package com.sc.controller;

import com.sc.bean.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "/login11")
    public void login1(Login login){
        String username = login.getUsername();
        String password = login.getPassword();
        System.out.println(username+" ------------  "+password);
    }

//    @RequestMapping(value = "/login11")
//    public void login2(HttpServletRequest request, String username, String password){
//
//        System.out.println(username+" ------------  "+password);
//    }
}
