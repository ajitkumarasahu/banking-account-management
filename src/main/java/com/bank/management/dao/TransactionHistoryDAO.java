package com.bank.management.dao;

import com.bank.management.model.Transaction;
import com.bank.management.util.DBUtil;

import java.sql.*;
import java.util.*;

/**
 * DAO class responsible for handling transaction history
 * and generating basic transaction-related reports.
 */
public class TransactionHistoryDAO {

    /**
     * Retrieves all transactions related to a specific account.
     *
     * @param accountId the account ID whose transactions are to be fetched
     * @return list of Transaction objects in descending order of date
     * @throws Exception if database access fails
     */
    public List<Transaction> getByAccount(int accountId) throws Exception {

        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE account_id=? ORDER BY transaction_date DESC";

        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setInt(1, accountId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Transaction t = new Transaction();
            t.setTransactionId(rs.getInt("transaction_id"));
            t.setAccountId(rs.getInt("account_id"));
            t.setTransactionType(rs.getString("transaction_type"));
            t.setAmount(rs.getDouble("amount"));
            t.setTransactionDate(rs.getTimestamp("transaction_date"));
            t.setRemarks(rs.getString("remarks"));
            list.add(t);
        }
        return list;
    }

    /**
     * Returns total number of customers in the system.
     *
     * @return total customer count
     * @throws Exception if database access fails
     */
    public int totalCustomers() throws Exception {

        String sql = "SELECT COUNT(*) FROM customers";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    /**
     * Calculates total deposited amount across all accounts.
     *
     * @return total deposited amount
     * @throws Exception if database access fails
     */
    public double totalDeposits() throws Exception {

        String sql = "SELECT SUM(amount) FROM transactions WHERE transaction_type='DEPOSIT'";
        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getDouble(1);
    }
}
