package com.login.dao.impl;

import com.login.dao.UserDao;
import com.login.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//与数据库发生交互
public class UserDaoImpl implements UserDao {

    public Users checkUsers(Users users) throws ClassNotFoundException {

        //定义连接的对象
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
}
