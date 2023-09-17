package com.sly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* response: 表示服务端返回数据的响应对象
* 响应头：
* 响应行：
* 响应体：
*/
@WebServlet(name = "ResponseServlet", value = "/ResponseServlet")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头，按照健值对的方式
        response.setHeader("hhhh", "hhhhhhhh");  //setHeader当key相同的时候，对值进行覆盖
        response.addHeader("ssss","ssssssss");   //addHeader当key相同的时候，不会对值进行覆盖
        //设置响应状，添加响应状态
        response.sendError(404, "not found");
        //设置输出流输出的内容
        response.setContentType("text/html"); //设置渲染数据的格式
        response.setHeader("Content-Type", "text/html"); //二者同样的作用
        response.getWriter().write("JSP is basis");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
