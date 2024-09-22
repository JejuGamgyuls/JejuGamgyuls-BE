package com.gamgyuls.gamgyuls.routeIdName.controller;

import com.gamgyuls.gamgyuls.routeIdName.model.dao.RouteIdNameDAO;
import com.gamgyuls.gamgyuls.routeIdName.model.service.RouteIdNameSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Controller
@RestController
public class RouteIdNameController {
    @Autowired
    RouteIdNameDAO dao;

    @Autowired
    RouteIdNameSerivce serivce;

    @GetMapping("/routeNumToId")
    public String routeNumToId(@RequestParam("routeName") String routeName) throws SQLException {
        try {
            String routeId = dao.read(routeName);
            return routeId != null ? routeId : "No route found";
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그 출력
            return "Error occurred while fetching the route ID.";
        }
    }
}
