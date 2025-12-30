package com.bank.management.util;

import com.bank.management.config.DatabaseConfig;
import java.sql.Connection;

/**
 * Utility class for obtaining database connections.
 * Provides a simple method to get a JDBC Connection
 * using the DatabaseConfig class.
 */
public class DBUtil {

    /**
     * Returns a JDBC Connection from the DatabaseConfig.
     *
     * @return Connection object
     * @throws RuntimeException if connection cannot be established
     */
    public static Connection getConnection() {
        try {
            return DatabaseConfig.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
