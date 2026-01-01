package com.bank.management.service;

import com.bank.management.dao.*;
import com.bank.management.model.*;

import java.util.List;

/**
 * Service class responsible for generating reports
 * related to transactions and administrative summaries.
 */
public class ReportService {

    // DAO used for fetching transaction history and statistics
    TransactionHistoryDAO dao = new TransactionHistoryDAO();

    // DAO used for account-related validations
    AccountDAO accDao = new AccountDAO();

    /**
     * Fetches transaction history for a given account number.
     *
     * @param accNo account number whose transaction history is required
     * @return list of transactions associated with the account
     * @throws Exception if account is not found or database access fails
     */
    public List<Transaction> history(String accNo) throws Exception {

        Account a = accDao.findByAccountNumber(accNo);
        if (a == null)
            throw new RuntimeException("Account not found");

        return dao.getByAccount(a.getAccountId());
    }

    /**
     * Generates a summary report for administrators.
     * Includes total number of customers and total deposits.
     *
     * @return JSON formatted summary string
     * @throws Exception if database access fails
     */
    public String adminSummary() throws Exception {

        int customers = dao.totalCustomers();
        double totalDeposit = dao.totalDeposits();

        return "{ \"totalCustomers\": " + customers + ", \"totalDeposits\": " + totalDeposit + " }";
    }
}
