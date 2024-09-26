package com.gamgyuls.gamgyuls.controller;

import com.gamgyuls.gamgyuls.Service.AuthService;
import com.gamgyuls.gamgyuls.dto.ResponseDto;
import com.gamgyuls.gamgyuls.dto.SignUpDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

}
