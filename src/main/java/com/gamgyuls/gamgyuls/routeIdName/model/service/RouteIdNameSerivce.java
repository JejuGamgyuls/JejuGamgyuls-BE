package com.gamgyuls.gamgyuls.routeIdName.model.service;

import java.sql.SQLException;

public interface RouteIdNameSerivce {

    public String read(String routeName) throws SQLException;
}
