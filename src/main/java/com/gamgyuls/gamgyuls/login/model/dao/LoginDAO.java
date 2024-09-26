package com.gamgyuls.gamgyuls.login.model.dao;

import com.gamgyuls.gamgyuls.login.dto.Login;

import java.sql.SQLException;

public interface LoginDAO {

    public Boolean read(Login dto) throws SQLException;
}
