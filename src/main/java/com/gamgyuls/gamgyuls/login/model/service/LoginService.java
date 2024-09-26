package com.gamgyuls.gamgyuls.login.model.service;

import java.sql.SQLException;
import com.gamgyuls.gamgyuls.login.dto.Login;

public interface LoginService {
    public Boolean read(Login dto) throws SQLException;

}
