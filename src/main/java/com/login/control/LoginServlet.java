package com.login.control;

import com.login.entity.Users;
import com.login.service.UserService;
import com.login.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("GET");

        //获取请求的数据
        String name = request.getParameter("name");
        // System.out.println(name);
        String pwd = request.getParameter("pwd");
        //封装对象
        Users users = new Users(name, pwd);
        //背service进行逻辑处理
        try {
            Users u = userService.checkUser(users);
            System.out.println(u);
            if(u != null) {
                response.getWriter().write("success");
                //请求转发
                //request.getRequestDispatcher("/HelloRedirect").forward(request, response);
                //重定向，这里如果只写HelloRedirect，显示的URL是localhost:8080/HelloRedirect，所以在写路径的时候应该注意，这里一定要写绝对路径
                response.sendRedirect("/JavaWeb/HelloRedirect");
            }else {
                //如果登录失败应该重定向到登录页面，重新登录
                //这里是相对路径
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                //response.getWriter().write("fail");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
