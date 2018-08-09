package com.koei.data.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koei.test.http.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: paul
 * @Date: 2018/8/6 16:54
 * @Description:
 */

@Controller
@RequestMapping("/call")
//测试指定 voip userId  20180807007
//测试指定 pstn userId  20180807009

public class CallController {
    private final String  SERVICE_NUMBER="008607566114305";
    @RequestMapping("/callAction")
    @ResponseBody
    public String call(HttpServletRequest request, HttpServletResponse response){
        String roomId=call1(request,response);
        if("".equals(roomId) || "-1".equals(roomId)){
            return "";
        }else{
            call2(request,response,roomId);
            return "";
        }
    }

    /***
     * voip 发起呼叫 createRoom 拿到 roomid
     * @param request
     * @param response
     * @return
     */
    public String call1(HttpServletRequest request, HttpServletResponse response){
        //return "index";
        String phone=request.getParameter("phone");
        String url="createRoom";
        JSONObject obj=new JSONObject();
        JSONObject objatt=new JSONObject();
        obj.put("appId", "1400118134");
        obj.put("nonce", "333");
        obj.put("requestId", "This is a test ");
        objatt.put("userId","20180807007");
        objatt.put("userType","1");
        objatt.put("phone","008618182813107");
        obj.put("attendee", objatt);
        try {
            String retCode=HttpClientUtils.class.newInstance().post2(url,obj);
            if(!("-1".equals(retCode))){
                JSONObject jsonObj=JSON.parseObject(retCode);
                String errorCode=jsonObj.getString("errorCode");
                if("0".equals(errorCode)){
                    return jsonObj.getString("roomId");
                }else{
                    return "-1";
                }
                //System.out.println(jsonObj.get("errorCode"));
            }else{
                return "-1";
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
        return phone;
    }

    /***
     * pstn 发起pstn呼叫 dialUser
     * @param request
     * @param response
     * @param roomId
     * @return
     */
    public String call2(HttpServletRequest request, HttpServletResponse response,String roomId){
        //String phone=request.getParameter("phone");
        String url="dialUser";
        JSONObject obj=new JSONObject();
        JSONObject objatt=new JSONObject();
        obj.put("appId", "1400118134");
        obj.put("nonce", "333");
        obj.put("requestId", "This is a test ");
        obj.put("roomId",roomId);
        objatt.put("userId","20180807009");
        objatt.put("userType","0");
        objatt.put("phone","008618182813107");
        obj.put("attendee", objatt);
        obj.put("servingNum",SERVICE_NUMBER);
        try {
            String retCode=HttpClientUtils.class.newInstance().post2(url,obj);
            if(!("-1".equals(retCode))){
                JSONObject jsonObj=JSON.parseObject(retCode);
                String errorCode=jsonObj.getString("errorCode");
                System.out.println(jsonObj.get("errorCode"));
                if("0".equals(errorCode)){
                    return jsonObj.getString("roomId");
                }else{
                    return "-1";
                }
                //System.out.println(jsonObj.get("errorCode"));
            }else{
                return "-1";
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }

    /**
     * 功能描述: 
     * 回调接口
     * @param: 
     * @return: 
     * @auther: qiugy
     * @date: 2018/8/9 18:46
     */
    @RequestMapping("/status")
    public String retStatus(HttpServletRequest request,HttpServletResponse response){
        String  status= request.getParameter("status");
        String  roomId= request.getParameter("roomId");
        String  attendee= request.getParameter("attendee");
        System.out.println("---------------------------------回调 status---------------------------------------------------------"+status);
        System.out.println("status==="+status);
        System.out.println("roomId==="+roomId);
        System.out.println("attendee==="+attendee);

        if("ringing".equals(status)|| "answered".equals(status)){

        }
        return "-1";
    }

    /***
     * 将手机用户加入房间
     * @param request
     * @param response
     * @return
     */
    public  String  call4(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        String url="createRoom";
        JSONObject obj=new JSONObject();
        JSONObject objatt=new JSONObject();
        obj.put("appId", "1400118134");
        obj.put("nonce", "333");
        obj.put("requestId", "This is a test ");
        objatt.put("userId","20180807007");
        objatt.put("userType","1");
        objatt.put("phone","008618182813107");
        obj.put("attendee", objatt);
        try {
            String retCode=HttpClientUtils.class.newInstance().post2(url,obj);
            if(!("-1".equals(retCode))){
                JSONObject jsonObj=JSON.parseObject(retCode);
                String errorCode=jsonObj.getString("errorCode");
                if("0".equals(errorCode)){
                    return jsonObj.getString("roomId");
                }else{
                    return "-1";
                }
                //System.out.println(jsonObj.get("errorCode"));
            }else{
                return "-1";
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
        return phone;
    }


}
