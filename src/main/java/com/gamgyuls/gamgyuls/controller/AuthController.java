package com.gamgyuls.gamgyuls.controller;

import com.gamgyuls.gamgyuls.Service.AuthService;
import com.gamgyuls.gamgyuls.dto.EmailCheckDto;
import com.gamgyuls.gamgyuls.dto.IdCheckDto;
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

    @DeleteMapping("/signOut/{userId}")
    public ResponseDto<?> deleteUser(@PathVariable String userId) {
        System.out.println("Deleting user with ID: " + userId);
        boolean result = authService.deleteUser(userId);
        if (result) {
            return ResponseDto.setSuccess("User deleted successfully", null);
        } else {
            return ResponseDto.setFailed("Failed to delete user");
        }
    }

    // 아이디 중복 확인
    @PostMapping("/check-id")
    public ResponseDto<?> checkId(@RequestBody IdCheckDto idCheckDto) {
        String userId = idCheckDto.getUserId();
        System.out.println("Received id: " + userId);
        if (userRepository.existsByUserId(userId)) {
            return ResponseDto.setFailed("Existed Id");
        }
        return ResponseDto.setSuccess("Id is available", null);
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
