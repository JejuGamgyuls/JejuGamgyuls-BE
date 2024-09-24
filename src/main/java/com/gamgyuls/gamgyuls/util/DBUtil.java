package com.gamgyuls.gamgyuls.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBUtil {

    private final String driverName = "org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mariadb://ureca-jeju.c508aimkwxnt.ap-northeast-2.rds.amazonaws.com:3306/ureca?serverTimezone=UTC";
    private final String user = "admin";

    private final String pass = "urecaureca";

    public DBUtil() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}