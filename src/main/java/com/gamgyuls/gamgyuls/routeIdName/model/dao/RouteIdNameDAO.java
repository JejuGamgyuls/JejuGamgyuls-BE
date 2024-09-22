package com.gamgyuls.gamgyuls.routeIdName.model.dao;


import java.sql.SQLException;

public interface RouteIdNameDAO {

    public String read(String routeName) throws SQLException;

}
