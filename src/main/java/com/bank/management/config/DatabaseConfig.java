package com.bank.management.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

/**
 * Database configuration utility class.
 * Loads database connection properties from
 * application.properties and provides a JDBC Connection.
 */
public class DatabaseConfig {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    // Static block to load configuration and driver class
    static { 
        try (InputStream is = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
                                                    
            if (is == null) {
                throw new RuntimeException("application.properties file not found in classpath");
            }

            Properties props = new Properties();
            props.load(is);

            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty(""); // fixed missing key
            driver = props.getProperty("db.driver");

            // Load JDBC driver
            Class.forName(driver);

        } catch (Exception e) {
            // Use runtime exception to fail fast in case of config issues
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    /**
     * Returns a new JDBC connection using loaded configuration.
     *
     * @return JDBC Connection
     * @throws Exception if connection cannot be established
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
