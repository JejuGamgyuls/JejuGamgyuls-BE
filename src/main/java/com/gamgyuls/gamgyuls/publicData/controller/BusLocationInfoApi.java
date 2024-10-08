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
public class BusLocationInfoApi {

    @Value("${publicdata.api.key}")
    private String apiKey; // application.properties에서 API 키를 설정할 수 있도록

    @GetMapping("/getLowBusPosByRtid")
    @Operation(summary = "노선ID로 저상버스의 위치정보를 조회", description = "노선 ID에 해당하는 저상버스의 위치정보 조회")
    public ResponseEntity<String> getRouteInfo (@RequestParam String busRouteId) {
        String apiUrl = "http://ws.bus.go.kr/api/rest/buspos/getLowBusPosByRtid"
                + "?serviceKey=" + apiKey + "&busRouteId=" + busRouteId;


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
