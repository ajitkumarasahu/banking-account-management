package com.bank.management.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConfig {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static { 
        try (InputStream is = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties props = new Properties();
            props.load(is);

            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("");
            driver = props.getProperty("db.driver");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
