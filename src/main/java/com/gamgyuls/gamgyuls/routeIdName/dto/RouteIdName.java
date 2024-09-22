package com.gamgyuls.gamgyuls.routeIdName.dto;

public class RouteIdName {

    private String routeName;
    private String routeId;

    public RouteIdName(String routeName, String routeId) {
        this.routeName = routeName;
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "RouteIdName{" +
                "routeName='" + routeName + '\'' +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}
