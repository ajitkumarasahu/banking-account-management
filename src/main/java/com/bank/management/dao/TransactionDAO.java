package com.bank.management.dao;

import com.bank.management.model.Transaction;
import com.bank.management.util.DBUtil;

import java.sql.PreparedStatement;

/**
 * DAO class responsible for handling database operations
 * related to transactions.
 */
public class TransactionDAO {

    /**
     * Saves a transaction record in the database.
     *
     * @param t Transaction object containing transaction details
     */
    public void saveTransaction(Transaction t) throws Exception {

        String sql = "INSERT INTO transactions(account_id, transaction_type, amount, remarks) " +
                     "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setInt(1, t.getAccountId());
        ps.setString(2, t.getTransactionType());
        ps.setDouble(3, t.getAmount());
        ps.setString(4, t.getRemarks());

        ps.executeUpdate();
    }

    /**
     * Updates account balance after a transaction.
     *
     * @param accId Account ID
     * @param newBalance Updated balance amount
     */
    public void updateBalance(int accId, double newBalance) throws Exception {

        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        PreparedStatement ps = DBUtil.getConnection().prepareStatement(sql);
        ps.setDouble(1, newBalance);
        ps.setInt(2, accId);

        ps.executeUpdate();
    }
}
