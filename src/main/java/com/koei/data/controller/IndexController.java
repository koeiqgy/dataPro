package com.koei.data.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koei.dada.pojo.SysUser;
import com.koei.dada.pojo.User;
import com.koei.data.service.UserService;
import com.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/calll")
    public String call(){
        return "call";
    }

  /*  @Autowired
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
    public JSONObject loginAction(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        System.out.println(token);
        JSONObject result=new JSONObject();

        String token_str=Token.verifyToken(token);
        if("-1".equals(token_str)){
            result.put("success",false);
            result.put("msg","登陆失败");
        }else{
            Map map=Token.getDataByTokenSubject2(token_str);
            System.out.println(map);
            result.put("success",true);
            result.put("msg","注册成功");
            result.put("user",map);
        }
        return result;
    }

    @RequestMapping("/registerAction")
    @ResponseBody
    public JSONObject register(SysUser user){
        JSONObject result= new JSONObject();
        SysUser ret_user=userService.add(user);
        if(ret_user!=null){
            //String user_json=JSONObject.toJSONString(result);
            String user_json=JSON.toJSONString(ret_user);
            String token=Token.createToken(user_json);
            String str="xxxx";
            result.put("success",true);
            result.put("msg","注册成功");
            result.put("user",token);
        }else{
            result.put("success",false);
            result.put("msg","注册失败");
        }
        return result;
    }
*/
}

