package com.sly;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestServlet", value = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //一下这些都是！！请求行！！中的内容
        //获得请求方式
        String method = request.getMethod();
        System.out.println(method);        // GET
        //获得请求的完整路径
        String url = String.valueOf(request.getRequestURL());
        System.out.println(url);           // http://localhost:8080/JavaWeb1/RequestServlet
        //获得请求中的资源路径
        String uri = request.getRequestURI();
        System.out.println(uri);           // /JavaWeb1/RequestServlet
        //获取请求中的协议
        String scheme = request.getScheme();
        System.out.println(scheme);       // http

        //获取！！请求头！！数据
        //获取浏览器信息，通过key获取value值
        String userAgent = request.getHeader("userAgent");
        System.out.println(userAgent);
        //获取请求头信息中的所有key的枚举对象
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ": " + value);
        }
        //获取用户的数据，通过jsp中定义的标签名称
        String name = request.getParameter("name"); //当参数名称与jsp页面不一致的时候，该参数值拿不到
        String pwd = request.getParameter("pwd");
        System.out.println(name + ": " + pwd);
        /*如果是复选框内的值，不可以使用getParameter方法了，改成getParameterValues这个方法，然后用数组的形式进行获取
        String[] parameterValues = request.getParameterValues("fav");
        for(String parameter : parameterValues){
            System.out.println(parameter);
        }*/

        /*
        * request常用方法总结：
        * getRequestURL: 获取客户端完整的URL
        * getRequestURI: 获取请求行中的资源名部分
        * getQueryString: 获取请求行的参数部分
        * getMethod: 获取请求方式
        * getScheme: 获取请求协议
        * getRemoteAddr: 获取客户端的IP
        * getRemoteHost: 获取客户端的完整主机名
        * getRemotePort: 获取客户端的网络端口号
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
