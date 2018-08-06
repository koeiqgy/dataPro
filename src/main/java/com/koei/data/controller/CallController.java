package com.koei.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: paul
 * @Date: 2018/8/6 16:54
 * @Description:
 */

@Controller
@RequestMapping("/calls")
public class CallController {

    @RequestMapping("/call1")
    public String call1(HttpServletRequest request, HttpServletResponse response){
        //return "index";


        return "";
    }


}
