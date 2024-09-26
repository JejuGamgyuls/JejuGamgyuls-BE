package com.gamgyuls.gamgyuls.favorite.dto;

public class FavoriteDTO {
    private String busStopId;
    private String busStopName;
    private String routeName;
    private String routeId;
    private String userId;


    public FavoriteDTO(String busStopId, String busStopName, String routeName, String routeId, String userId) {
        this.busStopId = busStopId;
        this.busStopName = busStopName;
        this.routeName = routeName;
        this.routeId = routeId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FavoriteDTO{" +
                "busStopId='" + busStopId + '\'' +
                ", busStopName='" + busStopName + '\'' +
                ", routeName='" + routeName + '\'' +
                ", routeId='" + routeId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}