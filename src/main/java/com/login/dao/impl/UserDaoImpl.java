package com.login.dao.impl;

import com.login.dao.UserDao;
import com.login.entity.Users;

import java.sql.*;


//与数据库发生交互
public class UserDaoImpl implements UserDao {

    public Users checkUsers(Users users) throws SQLException {

        //定义连接的对象
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Users u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sly","root","SLYsly010129");
            //获取预处理块
            pstm = conn.prepareStatement("select * from Users where name = ? and pwd = ?");
            //给?赋值
            pstm.setString(1, users.getName());
            pstm.setString(2, users.getPwd());
            //执行sql语句
            rs = pstm.executeQuery();
            //从resultset中获取结果
            while (rs.next()){
                u = new Users(rs.getInt("id"), rs.getString("name"), rs.getString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            rs.close();
            pstm.close();
            conn.close();
        }

        return u;
    }
}
