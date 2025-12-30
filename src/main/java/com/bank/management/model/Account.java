package com.bank.management.model;

/**
 * Model class representing a Bank Account.
 * This class is used to transfer account data
 * between application layers.
 */
public class Account {

    /** Unique identifier for the account */
    private int accountId;

    /** Unique account number */
    private String accountNumber;

    /** Customer ID associated with this account */
    private int customerId;

    /** Current balance of the account */
    private double balance;

    /** Type of account (e.g., SAVINGS, CURRENT) */
    private String accountType;

    /** Status of the account (ACTIVE / CLOSED) */
    private String status;

    // -------------------- Getters and Setters --------------------

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
