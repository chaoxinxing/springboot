package com.ceb.ymz.controller;

import com.ceb.ymz.bean.User;
import com.ceb.ymz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author fseve
 * @Date 2020/11/3 10:06
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(){
        System.out.println("to index.html");
        return "index";
    }

    @RequestMapping("/userLogin")
    public String userLogin(){
        return "user/login";
    }

    @RequestMapping("/userRegister")
    public String userRegister(){
        return "user/register";
    }

    @RequestMapping("/user/login")
    public String login(User user, Map<String,Object> map, HttpSession session){

        User user1 = userService.login(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            return "redirect:/";
        }else if(userService.existPhone(user)){
            map.put("msg","密码错误!");

        }else {
            map.put("msg","手机号未注册，请先注册！");
            return "user/register";
        }

        return "user/login";
    }

    @RequestMapping("/user/register")
    public String register(User user,@RequestParam("rePassword") String rePassword, Map<String,Object> map){
        String password = user.getPassword();
        if(!password.equals(rePassword)){
            map.put("msg","两次密码不同请重新输入");
        }else if(userService.existPhone(user)){
            map.put("msg","手机号已注册，请登录！");
            return "user/login";
        }else {
            userService.register(user);
            map.put("msg","注册成功，请登录！");
            return "user/login";
        }
        return "user/register";
    }
}
