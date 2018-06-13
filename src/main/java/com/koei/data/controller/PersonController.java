package com.koei.data.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
    @RequestMapping("/getPerson")
    public Map<String,Object> getPerson(){
        String name="paul";
        Map map=new HashMap<String,Object>();
        String res=name+"001";
        map.put("id",res);
        return map;
    }

    @RequestMapping("/getDept")
    public JSONObject getDept(HttpServletRequest request, HttpServletResponse response){
        JSONObject obj=new JSONObject();
        String key=request.getParameter("key");
        String publicKey="koei2013";
        if(publicKey.equals(key)){
            obj.put("flag","success");
            obj.put("id","1");
            obj.put("name","张飞");
        }else{
            obj.put("flag","fail");
            obj.put("msg","错误返回");
        }
        return obj;
    }
    @RequestMapping("/personView")
    public ModelAndView getPersonVeiw(HttpServletRequest request){
        ModelAndView mv=new ModelAndView("/form.html");
        mv.addObject("name","paul");
        return mv;
    }
    @RequestMapping("/person")
    public ModelAndView getDeptView(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv=new ModelAndView("/person");
        mv.addObject("msg","2018");
        mv.addObject("tel","1990");
        return mv;
    }
}
