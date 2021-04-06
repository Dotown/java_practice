package com.zhang.jdbc1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * author PC
 * create 2021-03-05-22:32
 */
public class PreparedStatementUpdateTest2 {
    @Test
    public void testInsert() throws IOException, SQLException, ParseException {
        InputStream ras = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            ras = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties t = new Properties();
            t.load(ras);
            String user = t.getProperty("user");
            String password = t.getProperty("password");
            String url = t.getProperty("url");
            String driverClass = t.getProperty("driverClass");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO customers(name,email,birth)VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"Thor");
            ps.setString(2,"Thor@gamil.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1997-5-20");
            ps.setDate(3,new java.sql.Date(date.getTime()));

            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
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
            try {
                if (ras!=null){
                    ras.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
