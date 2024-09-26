package com.gamgyuls.gamgyuls.controller;

import com.gamgyuls.gamgyuls.Service.AuthService;
import com.gamgyuls.gamgyuls.dto.EmailCheckDto;
import com.gamgyuls.gamgyuls.dto.ResponseDto;
import com.gamgyuls.gamgyuls.dto.SignUpDto;
import com.gamgyuls.gamgyuls.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    // 이메일 중복 확인
    @PostMapping("/check-email")
    public ResponseDto<?> checkEmail(@RequestBody EmailCheckDto emailCheckDto) {
        String email = emailCheckDto.getEmail();
        System.out.println("Received email: " + email);
        if (userRepository.existsByEmail(email)) {
            return ResponseDto.setFailed("Existed Email");
        }
        return ResponseDto.setSuccess("Email is available", null);
    }
}
