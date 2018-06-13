package com.koei.data.controller;

import com.koei.dada.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")

public class IndexController {
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String index(Model modelMap) {
        ArrayList<User> list =new ArrayList<User>();
        list.add(new User(1,"paul",23));
        list.add(new User(2,"tom",25));
        list.add(new User(3,"jimmy",28));

        modelMap.addAttribute("msgList",list);
        modelMap.addAttribute("msg","测试属性");
        return "index";
    }

    @RequestMapping(value="home2",method=RequestMethod.GET)
    public ModelAndView index2(){
            ModelAndView mol=new ModelAndView("index");
            mol.addObject("msg","hello springboot");
            return mol;
    }

    @RequestMapping(value="/getJson",method=RequestMethod.GET)
    @ResponseBody
    public String getJson(){
        return "hello";
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public List<User> getList(){
          List listData =new ArrayList<User>();
          User user=new User(1,"paul1",25);
          User user2=new User(2,"paul2",26);
          User user3=new User(3,"paul3",27);

          listData.add(user);
          listData.add(user2);
          listData.add(user3);
          return listData;
    }
}
