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
public class BusPublicApi {

    @Value("${publicdata.api.key}")
    private String apiKey; // application.properties에서 API 키를 설정할 수 있도록

    @GetMapping("/getRouteInfo")
    @Operation(summary = "노선 기본 정보 조회", description = "아이디에 해당하는 노선 정보(기점, 종점, 배차간격 등등)에 대한 조회")
    public ResponseEntity<String> callPublicApi(@RequestParam String busRouteId) {
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getRouteInfo"
                + "?serviceKey=" + apiKey + "&busRouteId=" + busRouteId +"&resultType=json";


        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/getBusRouteList")
    @Operation(summary = "노선번호에 해당하는 노선 목록 조회", description = "아이디에 해당하는 노선 정보(기점, 종점, 배차간격 등등)에 대한 조회")
    public ResponseEntity<String> callPublicAPI(@RequestParam String strSrch){
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList"
                + "?serviceKey=" + apiKey + "&strSrch=" + strSrch + "&resultType=json";

        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/getStaionByRoute")
    @Operation(summary = "노선번호에 해당하는 노선 목록 조회", description = "아이디에 해당하는 노선 정보(기점, 종점, 배차간격 등등)에 대한 조회")
    public ResponseEntity<String> getStaionByRoute(@RequestParam String busRouteId){
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute"
                + "?serviceKey=" + apiKey + "&busRouteId=" + busRouteId + "&resultType=json";

        RestTemplate restTemplate = new RestTemplate();

        System.out.println(apiUrl);

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }



    @GetMapping("/getStaionByRouteList")
    @Operation(summary = "노선별 경유 정류소 조회 서비스 ", description = "노선ID에 해당하는 경유 정류장 목록을 조회 (정류소 ID, 이름, 좌표, 구간속도, 회차지 여부 등)")
    public ResponseEntity<String> getStaionsByRouteList(@RequestParam String busRouteId){
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute"
                + "?ServiceKey=" + apiKey + "&busRouteId" + busRouteId + "&resultType=json";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(apiUrl);
        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/getRoutePath")
    @Operation(summary = "노선의 지도상 경로 리턴", description = "노선ID에 노선의 형상 목록을 조회")
    public ResponseEntity<String> getRoutePath(@RequestParam String busRouteId){
        String apiUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getRoutePath"
                + "?serviceKey=" + apiKey + "&busRouteId" + busRouteId + "&resultType=json";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("API 요청 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/getBusPosition")
    @Operation(summary = "버스 위치 조회 ", description = "노선ID에 해당하는 버스 위치 조회")
    public ResponseEntity<String> getBusPosition(@RequestParam String busRouteId){
        String apiUrl = "http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid"
                + "?serviceKey=" + apiKey + "&busRouteId=" + busRouteId + "&resultType=json";
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
