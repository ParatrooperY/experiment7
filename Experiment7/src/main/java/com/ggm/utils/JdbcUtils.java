package com.ggm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yz
 * @create 2021-11-22-11:15
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DruidDataSource) app.getBean(DruidDataSource.class);
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
