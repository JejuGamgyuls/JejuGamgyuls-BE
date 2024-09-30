package com.gamgyuls.gamgyuls.login.model.dao;

import com.gamgyuls.gamgyuls.login.dto.Login;

import java.sql.SQLException;
import java.util.Map;

public interface LoginDAO {

    Map<String, Object> read(Login dto) throws SQLException;
}
