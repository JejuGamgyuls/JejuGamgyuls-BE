package com.gamgyuls.gamgyuls.login.controller;

import com.gamgyuls.gamgyuls.login.dto.Login;
import com.gamgyuls.gamgyuls.login.model.dao.LoginDAO;
import com.gamgyuls.gamgyuls.login.model.service.LoginService;
import com.gamgyuls.gamgyuls.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;
@RestController
public class LoginController {
    private final LoginDAO dao;
    private final LoginService service;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(LoginDAO dao, LoginService service, JwtUtil jwtUtil) {
        this.dao = dao;
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @Operation(summary = "아이디와 패스워드를 통한 로그인", description = "로그인 성궁시 true, 실패시 false")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Login dto) throws SQLException {
        Boolean loginResult = dao.read(dto);

        try {
            Map<String, Object> response = new HashMap<>();
            if (loginResult) {
                String jwtToken = jwtUtil.createToken(dto.getUserId());

                response.put("message", "로그인 성공");
                response.put("jwt", jwtToken);

                return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
            } else {
                response.put("message", "로그인 실패");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) { // General exception handling
            e.printStackTrace(); // Log exception
            Map<String, Object> response = new HashMap<>();
            response.put("message", "로그인 API 에러");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }
}