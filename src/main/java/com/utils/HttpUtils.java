package com.utils;

import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: paul
 * @Date: 2018/7/26 14:07
 * @Description:
 */
public class HttpUtils {
    private static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain; charset=utf8";
    private static final String DEFAULT_HTML_CONTENT_TYPE = "text/html; charset=utf8";
    private static final String DEFAULT_JSON_CONTENT_TYPE = "application/json; charset=utf8";

    public static boolean isEmpty(String str){
        return StringUtils.isEmpty(str);
    }

    public static void returnJson(HttpServletResponse response, String text){
        PrintWriter pw=null;
        try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType(DEFAULT_JSON_CONTENT_TYPE);
            pw=response.getWriter();
            pw.write(text);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(pw!=null)
                pw.close();
        }
    }

}
