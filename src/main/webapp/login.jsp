<%--
  Created by IntelliJ IDEA.
  User: shanluyao
  Date: 16/9/2023
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="LoginServlet" method="get">
    用户名：<input type="text" name="name" value=""></br>
    密码：<input type="password" name="pwd" value=""></br>
    <input type="submit" value="login">
</form>
</body>
</html>
