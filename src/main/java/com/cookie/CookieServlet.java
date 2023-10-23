package com.cookie;

import com.login.control.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //创建cookie对象
        Cookie cookie = new Cookie("001", "Hongkong");
        //将cookie设置到response对象中
        response.addCookie(cookie);
        //给cookie对象添加有效期，单位是秒
        cookie.setMaxAge(3*24*3600);
        //给cookie设置固定路径值
        cookie.setPath("/CookieServlet/abc");//设置指定的路径，一个cookie对应一个路径
        response.getWriter().write("studying cookie");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
