package com.gamgyuls.gamgyuls.favorite.model.dao;

import com.gamgyuls.gamgyuls.favorite.dto.FavoriteDTO;
import com.gamgyuls.gamgyuls.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO{
    @Autowired
    private DBUtil dbUtil;


    @Override
    public void addFavorite(FavoriteDTO Favorite) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = dbUtil.getConnection();
            String sql = "INSERT INTO UserFavorite (busStopId, busStopName, routename, routeid, userId) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            System.out.println("===========");
            System.out.println(Favorite);
            pstmt.setString(1, Favorite.getBusStopId());
            pstmt.setString(2, Favorite.getBusStopName());
            pstmt.setString(3, Favorite.getRouteName());
            pstmt.setString(4, Favorite.getRouteId());
            pstmt.setString(5, Favorite.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<FavoriteDTO> getFavoriteById(String userId) {
        List<FavoriteDTO> favoriteList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM UserFavorite WHERE userId = ?";
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId); // Login DTO에서 userId 추출
            rs = pstmt.executeQuery();
            while (rs.next()) {
                FavoriteDTO favorite = new FavoriteDTO(
                        rs.getString("busStopId"),
                        rs.getString("busStopName"),
                        rs.getString("routename"),
                        rs.getString("routeid"),
                        rs.getString("userId")
                );
                favoriteList.add(favorite); // 리스트에 추가
            }

            return  favoriteList;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FavoriteDTO> getAllFavorites() {
        List<FavoriteDTO> favorites = new ArrayList<>();
        String sql = "SELECT * FROM UserFavorite";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try{
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                favorites.add(new FavoriteDTO(
                        rs.getString("busStopId"),
                        rs.getString("busStopName"),
                        rs.getString("routename"),
                        rs.getString("routeid"),
                        rs.getString("userId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    @Override
    public void deleteFavorite(String busStopId, String routeid, String userId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "DELETE FROM UserFavorite WHERE busStopId = ? and routeid = ? and userId = ?";
        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, busStopId);
            pstmt.setString(2, routeid);
            pstmt.setString(3, userId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
