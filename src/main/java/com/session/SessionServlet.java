package com.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5);//五秒后session失效，设置有效时长
        System.out.println(session.getId());//这里获得的是jsessionid
        //session.invalidate();//让session立刻失效，强制失效
        //为session设置属性
        session.setAttribute("111", "Zhangsan");
        response.getWriter().write("session servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
