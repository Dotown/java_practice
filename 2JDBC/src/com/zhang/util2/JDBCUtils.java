package com.zhang.util2;

import com.zhang.jdbc1.ConnectionTest1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * author PC
 * create 2021-03-05-23:03
 */
public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        InputStream ras = ConnectionTest1.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(ras);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void closeResource(Connection conn, Statement ps){
        try {
            if (ps!=null){
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
