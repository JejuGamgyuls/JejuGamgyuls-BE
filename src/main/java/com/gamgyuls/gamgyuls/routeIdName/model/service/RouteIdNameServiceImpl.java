package com.gamgyuls.gamgyuls.routeIdName.model.service;

import com.gamgyuls.gamgyuls.routeIdName.model.dao.RouteIdNameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RouteIdNameServiceImpl implements RouteIdNameSerivce{

    @Autowired
    RouteIdNameDAO dao;
    @Override
    public String read(String routeName) throws SQLException {
        return dao.read(routeName);
    }
}
