package com.gamgyuls.gamgyuls.publicData.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {

    @Value("${publicdata.api.key}")
    private String apiKey; // application.properties에서 API 키를 설정할 수 있도록

    @GetMapping("/bus-route")
    public ResponseEntity<String> callPublicApi() {
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getRouteInfo"
                + "?serviceKey=" + apiKey;


        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            System.out.println("response: " + response);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }
}