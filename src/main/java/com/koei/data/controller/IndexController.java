package com.koei.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.koei.dada.pojo.SysUser;
import com.koei.dada.pojo.User;
import com.koei.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/loginAction")
    @ResponseBody
    public JSONObject loginAction(){
        JSONObject result=new JSONObject();
        User user=new User(1,"tom",28);
        result.put("success","1");
        result.put("user",user);
        return result;
    }

    @RequestMapping("/registerAction")
    @ResponseBody
    public JSONObject register(SysUser user){
        JSONObject result= new JSONObject();
        SysUser ret_user=userService.add(user);
        if(ret_user!=null){
            result.put("success","1");
            result.put("user",ret_user);
        }else{
            result.put("success","-1");
        }
        return result;
    }

}

