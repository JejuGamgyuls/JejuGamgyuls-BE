package com.gamgyuls.gamgyuls.login.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.gamgyuls.gamgyuls.login.dto.Login;

public interface LoginService {
    public Map<String, Object> read(Login dto) throws SQLException;

}
