package com.zhang.jdbc1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * author PC
 * create 2021-03-05-16:03
 */
public class ConnectionTest1 {
    @Test
    public void test() throws IOException, SQLException {
        Properties t = new Properties();
        InputStream ras = ConnectionTest1.class.getClassLoader().getResourceAsStream("jdbc.properties");
        t.load(ras);
        String user = t.getProperty("user");
        String password = t.getProperty("password");
        String url = t.getProperty("url");
        String driverClass = t.getProperty("driverClass");

        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
    }

}
