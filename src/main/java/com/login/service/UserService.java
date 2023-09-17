package com.login.service;

import com.login.entity.Users;

import java.sql.SQLException;

public interface UserService {

    public Users checkUser(Users users) throws SQLException;
}

