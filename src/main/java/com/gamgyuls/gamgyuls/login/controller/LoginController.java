package com.gamgyuls.gamgyuls.login.controller;

import com.gamgyuls.gamgyuls.login.dto.Login;
import com.gamgyuls.gamgyuls.login.model.dao.LoginDAO;
import com.gamgyuls.gamgyuls.login.model.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LoginController {
    @Autowired
    LoginDAO dao;

    @Autowired
    LoginService service;

    @PostMapping("/login")
    @Operation(summary = "아이디와 패스워드를 통한 로그인", description = "로그인 성궁시 true, 실패시 false")
    public ResponseEntity<String> login(@RequestBody Login dto) throws SQLException{
        try{
            Boolean loginResult = dao.read(dto);
            if(loginResult){
                 return ResponseEntity.status(HttpStatus.ACCEPTED).body("로그인 성공");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("로그인 실패");
            }
        }catch (SQLException e){
            e.printStackTrace(); // 예외 발생 시 로그 출력
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 API 에러");
        }
    }
}
