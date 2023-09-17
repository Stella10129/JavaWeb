package com.login.service.impl;

import com.login.dao.UserDao;
import com.login.dao.impl.UserDaoImpl;
import com.login.entity.Users;
import com.login.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    public Users checkUser(Users users) throws SQLException {
        return userDao.checkUsers(users);
    }
}
