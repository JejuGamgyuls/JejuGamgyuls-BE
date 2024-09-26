package com.gamgyuls.gamgyuls.publicData.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class BusStopArriveInfo {

    @Value("${publicdata.api.key}")
    private String apiKey; // application.properties에서 API 키를 설정할 수 있도록

    @GetMapping("/getLowArrInfoByStId")
    @Operation(summary = "정류소ID로 저상버스 도착예정정보를 조회한다", description = "정류소ID에 해당하는 저상버스 도착예정정보 목록을 조회한다.")
    public ResponseEntity<String> callPublicApi(@RequestParam String stId) {
        String apiUrl = "http://ws.bus.go.kr/api/rest/arrive/getLowArrInfoByStId"
                + "?serviceKey=" + apiKey + "&stId=" + stId + "&resultType=json";

        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }
}
