package com.sc.controller;

import com.sc.bean.Users;
import com.sc.db.DBUtilsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    DBUtilsTemplate dbUtilsTemplate;

    @RequestMapping(value = "/time",method = RequestMethod.GET)
    public String home(Locale locale,Model model){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
        String datetime = dateFormat.format(date);
        model.addAttribute("time",datetime);
        return "home";
    }

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public ModelAndView index1(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name","this is index1");
        return  modelAndView;
    }

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2(HttpServletRequest request){
        request.setAttribute("age",100);
        return "home";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login1(String userName,String passWd){
        Users users= new Users();
        users.setUserName("AAAA");
        users.setPassWd("123123");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("users",users);
        return new ModelAndView("home",map);
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public List<Users> getUser(){
        //使用数组，传多个参数查询
        List<Users> list = dbUtilsTemplate.find(Users.class,"select * from myuser where phone=?","152123645111");
        return list;
    }
}
