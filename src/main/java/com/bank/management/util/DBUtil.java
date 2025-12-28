package com.bank.management.util;

import com.bank.management.config.DatabaseConfig;
import java.sql.Connection;

public class DBUtil {

    public static Connection getConnection() {
        try {
            return DatabaseConfig.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
