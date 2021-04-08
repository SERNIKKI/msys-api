package com.nikki.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static DataSource dataSource;
    public static Connection getConnection(){
        URL resource = DBUtils.class.getResource("/hikari.properties");
        String s = "resource/hikari.properties";
        HikariConfig configuration = new HikariConfig(resource.getPath());
//        System.out.println(resource.getPath());
        dataSource = new HikariDataSource(configuration);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }


}
