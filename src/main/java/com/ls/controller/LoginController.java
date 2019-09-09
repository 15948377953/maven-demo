package com.ls.controller;

import com.ls.pojo.User;
import com.ls.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/login")
    public ModelAndView Login(String userName,ModelAndView mv,HttpSession session){
        User user=userService.getUserByUserName(userName);
        if(user!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("user", user);
            //转发到main请求
            mv.addObject("id",user.getId());
            mv.setViewName("index/main");
        }else {
            //登录失败，设置失败信息，并调转到登录页面

            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("login");
        }
        return mv;
    }
}
