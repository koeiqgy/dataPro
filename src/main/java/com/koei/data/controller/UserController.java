package com.koei.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.koei.dada.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public String  getUser(Model model){
        model.addAttribute("title","用户");
        return "users";
    }

    @RequestMapping(value="getUserList",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User u=new User(1,"paul",30);
        list.add(u);
        return list;
    }
    @RequestMapping(value="getUserList/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(@PathVariable String id){
        List<User> list=new ArrayList<User>();
        User u=new User(Integer.valueOf(id),"paul",30);
        list.add(u);
        return list;
    }

    @RequestMapping(value="/addUserView")
    public String addUser(){
        return "form";
    }

    @RequestMapping(value="/addUser",method=RequestMethod.POST,params={"username","age","job"})
    @ResponseBody
    public String addUser(@RequestParam("username") String username,@RequestParam(value="age") String age,@RequestParam(value="job",required = false,defaultValue = "programer")String job ){

            return username+"&"+age+"&"+job;
    }

    @RequestMapping(value="/queryuList")
    @ResponseBody
    public Map queryuList(){
          Map map=new HashMap();
          map.put("userId",1);
          map.put("userName","孙悟空");
          map.put("userAge",20);
          return map;
    }

    @RequestMapping(value="/queryJson")
    @ResponseBody
    public JSONObject queryJson(HttpServletRequest request, HttpServletResponse response){
        String[] arrdata=request.getParameterValues("arrdata");
        JSONObject obj=new JSONObject();
        obj.put("userId",2);
        obj.put("userName","猪八戒");
        obj.put("userAge",20);
        return obj;
    }

}
