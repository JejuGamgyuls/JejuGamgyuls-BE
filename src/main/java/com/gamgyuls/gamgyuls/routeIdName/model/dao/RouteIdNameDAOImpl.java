package com.gamgyuls.gamgyuls.routeIdName.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gamgyuls.gamgyuls.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RouteIdNameDAOImpl implements RouteIdNameDAO {
    @Autowired
    private DBUtil dbUtil;
    @Override
    public String read(String routeName) throws SQLException {
        System.out.println("-------------------");
        String routeId = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dbUtil.getConnection();
            String sql = "SELECT routeid FROM routes WHERE routename=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, routeName);
            rs = pstmt.executeQuery();

            if (rs.next()) { // 결과가 존재하는지 확인
                System.out.println("rs: " + rs.toString());
                System.out.println("rs: " + rs.getString("routeId"));
                routeId = rs.getString("routeId");
                System.out.println(routeId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그 출력 (실제 서비스에서는 로깅 사용 권장)
            throw e; // 예외를 다시 던져서 호출자에게 알림
        } finally {
            // 자원 해제
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

        return routeId; // routeId가 없을 경우 null 반환
    }
}