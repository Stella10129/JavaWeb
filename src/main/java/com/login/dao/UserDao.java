package com.login.dao;

import com.login.entity.Users;

import java.sql.SQLException;

public interface UserDao {
    public Users checkUsers(Users users) throws SQLException;
}
