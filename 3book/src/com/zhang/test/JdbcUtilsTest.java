package com.zhang.test;

import com.zhang.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Dotown
 * @create 2021-03-24-19:08
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        JdbcUtils.close(conn);
    }
}
