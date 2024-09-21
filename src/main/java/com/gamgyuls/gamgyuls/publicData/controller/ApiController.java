package com.gamgyuls.gamgyuls.publicData.controller;  // 프로젝트 패키지 경로에 맞게 수정하세요

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {

    @GetMapping("/bus-route")
    public ResponseEntity<String> callPublicApi() {
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getRouteInfo"; // 공공데이터 API URL
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(response);
    }
}