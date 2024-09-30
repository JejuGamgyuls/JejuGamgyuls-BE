package com.gamgyuls.gamgyuls.login.model.dao;

import com.gamgyuls.gamgyuls.login.dto.Login; // Login DTO import
import com.gamgyuls.gamgyuls.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private DBUtil dbUtil;

    @Override
    public Map<String, Object> read(Login dto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String dbPWD = null;

        Map<String, Object> result = new HashMap<>(); // 로그인 결과를 담을 Map

        try {
            // DB 연결
            conn = dbUtil.getConnection();
            String sql = "SELECT pwd, name FROM user WHERE user_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getUserId()); // Login DTO에서 userId 추출
            rs = pstmt.executeQuery();

            if (rs.next()) { // 결과가 존재하는지 확인
                dbPWD = rs.getString("pwd"); // DB에서 가져온 비밀번호
                String userName = rs.getString("name");

                // 비밀번호 비교
                if (dto.getPwd().equals(dbPWD)) { // Login DTO에서 pwd 추출
                    System.out.println("일치합니다");
                    result.put("isLoginSuccessful", true);
                    result.put("userName", userName);
//                    return true; // 비밀번호가 일치하면 로그인 성공
                } else {
                    result.put("isLoginSuccessful", false);
//                    return false; // 비밀번호가 일치하지 않으면 로그인 실패
                }
            } else {
                result.put("isLoginSuccessful", false);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그 출력
            throw e; // 예외를 다시 던져서 호출자에게 알림
        } finally {
            // 자원 해제
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        return result; // 사용자 정보가 없으면 로그인 실패
    }

}