package com.gamgyuls.gamgyuls.login.model.service;

import com.gamgyuls.gamgyuls.login.dto.Login;
import com.gamgyuls.gamgyuls.login.model.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    LoginDAO dao;
    @Override
    public Boolean read(Login dto) throws SQLException {
        return dao.read(dto);
    }
}
