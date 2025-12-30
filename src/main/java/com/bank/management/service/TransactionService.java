package com.bank.management.service;

import com.bank.management.dao.AccountDAO;
import com.bank.management.dao.TransactionDAO;
import com.bank.management.model.Account;
import com.bank.management.model.Transaction;

/**
 * Service layer responsible for handling
 * all transaction-related business logic such as
 * deposit, withdrawal, and fund transfer.
 */
public class TransactionService {

    private TransactionDAO tdao = new TransactionDAO();
    private AccountDAO adao = new AccountDAO();

    /**
     * Deposits money into an account.
     *
     * @param accNo Account number
     * @param amount Amount to deposit
     */
    public void deposit(String accNo, double amount) throws Exception {

        if (amount <= 0)
            throw new RuntimeException("Amount must be greater than zero");

        Account a = adao.findByAccountNumber(accNo);
        if (a == null)
            throw new RuntimeException("Account not found");

        double newBalance = a.getBalance() + amount;

        // Update account balance
        tdao.updateBalance(a.getAccountId(), newBalance);

        // Save transaction record
        Transaction t = new Transaction();
        t.setAccountId(a.getAccountId());
        t.setTransactionType("DEPOSIT");
        t.setAmount(amount);
        t.setRemarks("Deposit Successful");

        tdao.saveTransaction(t);
    }

    /**
     * Withdraws money from an account.
     *
     * @param accNo Account number
     * @param amount Amount to withdraw
     */
    public void withdraw(String accNo, double amount) throws Exception {

        if (amount <= 0)
            throw new RuntimeException("Amount must be greater than zero");

        Account a = adao.findByAccountNumber(accNo);

        if (a == null)
            throw new RuntimeException("Account not found");

        if (a.getBalance() < amount)
            throw new RuntimeException("Insufficient balance");

        double newBalance = a.getBalance() - amount;

        // Update balance
        tdao.updateBalance(a.getAccountId(), newBalance);

        // Save transaction record
        Transaction t = new Transaction();
        t.setAccountId(a.getAccountId());
        t.setTransactionType("WITHDRAW");
        t.setAmount(amount);
        t.setRemarks("Withdraw Successful");

        tdao.saveTransaction(t);
    }

    /**
     * Transfers money from one account to another.
     *
     * @param fromAcc Source account number
     * @param toAcc Destination account number
     * @param amount Amount to transfer
     */
    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {

        if (fromAcc.equals(toAcc))
            throw new RuntimeException("Source and destination accounts must be different");

        if (amount <= 0)
            throw new RuntimeException("Amount must be greater than zero");

        Account from = adao.findByAccountNumber(fromAcc);
        Account to = adao.findByAccountNumber(toAcc);

        if (from == null || to == null)
            throw new RuntimeException("Invalid account number");

        if (from.getBalance() < amount)
            throw new RuntimeException("Insufficient balance for transfer");

        // Debit source account
        tdao.updateBalance(from.getAccountId(), from.getBalance() - amount);

        Transaction debit = new Transaction();
        debit.setAccountId(from.getAccountId());
        debit.setTransactionType("TRANSFER-DEBIT");
        debit.setAmount(amount);
        debit.setRemarks("Transferred to " + toAcc);
        tdao.saveTransaction(debit);

        // Credit destination account
        tdao.updateBalance(to.getAccountId(), to.getBalance() + amount);

        Transaction credit = new Transaction();
        credit.setAccountId(to.getAccountId());
        credit.setTransactionType("TRANSFER-CREDIT");
        credit.setAmount(amount);
        credit.setRemarks("Received from " + fromAcc);
        tdao.saveTransaction(credit);
    }
}
