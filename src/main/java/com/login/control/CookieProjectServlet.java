package com.login.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieProjectServlet", value = "/CookieProjectServlet")
public class CookieProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies.length != 0){
            for(Cookie c: cookies){
                String uname = c.getName();
                String uvalue = c.getValue();
                System.out.println(uname + ":" + uvalue);
            }
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
