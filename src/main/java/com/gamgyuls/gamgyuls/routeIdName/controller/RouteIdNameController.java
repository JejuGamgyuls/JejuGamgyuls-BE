package com.gamgyuls.gamgyuls.routeIdName.controller;

import com.gamgyuls.gamgyuls.routeIdName.model.dao.RouteIdNameDAO;
import com.gamgyuls.gamgyuls.routeIdName.model.service.RouteIdNameSerivce;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RouteIdNameController {
    @Autowired
    RouteIdNameDAO dao;

    @Autowired
    RouteIdNameSerivce serivce;

    @GetMapping("/routeNumToId")
    @Operation(summary = "노선 ID 값 찾기", description = "노선 번호에 맞는 노선ID 값을 반환")
    public String routeNumToId(@RequestParam("routeName") String routeName) throws SQLException {
        System.out.println("================");
        System.out.println("routeName: " + routeName);
        try {
            String routeId = dao.read(routeName);
            System.out.println("routeId: " + routeId);
            return routeId != null ? routeId : "No route found";
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그 출력
            return "Error occurred while fetching the route ID.";
        }
    }
}
