package com.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: paul
 * @Date: 2018/7/25 16:40
 * @Description:
 */
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter  implements Filter {
    Log log = LogFactory.getLog(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init myFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        String url_path = request.getServletPath();
        String token=request.getParameter("token");
        if (url_path.matches("\\S*(login*)S*$") || url_path.endsWith("js")|| url_path.endsWith("css")|| url_path.contains("login") || url_path.contains("register") ){
            filterChain.doFilter(request,response);
        }else{
            if(HttpUtils.isEmpty(token)){
                response.setContentType("application/json; charset=utf8");
                response.sendRedirect("/login");
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
