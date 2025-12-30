package com.bank.management.dao;

import com.bank.management.model.Account;
import com.bank.management.util.DBUtil;

import java.sql.*;

/**
 * Data Access Object (DAO) for handling Account-related
 * database operations.
 */
public class AccountDAO {

    /**
     * Creates a new account record in the database.
     *
     * @param a Account object containing account details
     * @return true if account is created successfully
     */
    public boolean createAccount(Account a) throws Exception {

        String sql = "INSERT INTO accounts(account_number, customer_id, balance, account_type, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setString(1, a.getAccountNumber());
        ps.setInt(2, a.getCustomerId());
        ps.setDouble(3, a.getBalance());
        ps.setString(4, a.getAccountType());
        ps.setString(5, "ACTIVE");

        return ps.executeUpdate() > 0;
    }

    /**
     * Fetches account details using account number.
     *
     * @param accNo Account number
     * @return Account object if found, otherwise null
     */
    public Account findByAccountNumber(String accNo) throws Exception {

        String sql = "SELECT * FROM accounts WHERE account_number = ?";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setString(1, accNo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Account a = new Account();
            a.setAccountId(rs.getInt("account_id"));
            a.setAccountNumber(rs.getString("account_number"));
            a.setCustomerId(rs.getInt("customer_id"));
            a.setBalance(rs.getDouble("balance"));
            a.setStatus(rs.getString("status"));
            return a;
        }
        return null;
    }

    /**
     * Updates account balance.
     *
     * @param accNo Account number
     * @param newBalance Updated balance
     * @return true if update is successful
     */
    public boolean updateBalance(String accNo, double newBalance) throws Exception {

        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setDouble(1, newBalance);
        ps.setString(2, accNo);

        return ps.executeUpdate() > 0;
    }

    /**
     * Closes an account by changing its status to CLOSED.
     *
     * @param accNo Account number
     * @return true if account is successfully closed
     */
    public boolean closeAccount(String accNo) throws Exception {

        String sql = "UPDATE accounts SET status = 'CLOSED' WHERE account_number = ?";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setString(1, accNo);

        return ps.executeUpdate() > 0;
    }

    /**
     * Checks whether an account exists.
     *
     * @param accNo Account number
     * @return true if account exists, otherwise false
     */
    public boolean accountExists(String accNo) throws Exception {

        String sql = "SELECT account_id FROM accounts WHERE account_number = ?";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setString(1, accNo);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
