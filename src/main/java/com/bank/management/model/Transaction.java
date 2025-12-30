package com.bank.management.model;

import java.sql.Timestamp;

/**
 * Model class representing a bank transaction.
 * This class stores details of deposits, withdrawals,
 * and fund transfers.
 */
public class Transaction {

    /** Unique identifier for the transaction */
    private int transactionId;

    /** Account ID related to the transaction */
    private int accountId;

    /** Type of transaction (DEPOSIT, WITHDRAW, TRANSFER) */
    private String transactionType;

    /** Transaction amount */
    private double amount;

    /** Date and time of the transaction */
    private Timestamp transactionDate;

    /** Additional remarks or description */
    private String remarks;

    // -------------------- Getters and Setters --------------------

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
