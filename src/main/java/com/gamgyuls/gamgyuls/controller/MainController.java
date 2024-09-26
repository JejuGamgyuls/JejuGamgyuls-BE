package com.gamgyuls.gamgyuls.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping("")
    @CrossOrigin(originPatterns = "http://localhost:3000") // cors 에러 해결
    public String hello() {
        return "Connection Success";
    }
}
