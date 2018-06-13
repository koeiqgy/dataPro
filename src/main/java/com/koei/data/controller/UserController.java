package com.koei.data.controller;

import com.koei.dada.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
}
