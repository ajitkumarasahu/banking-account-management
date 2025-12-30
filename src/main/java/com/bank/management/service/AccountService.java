package com.bank.management.service;

import com.bank.management.dao.AccountDAO;
import com.bank.management.model.Account;
import com.bank.management.util.AccountNumberGenerator;

/**
 * Service class responsible for handling
 * business logic related to bank accounts.
 */
public class AccountService {

    private AccountDAO dao = new AccountDAO();

    /**
     * Opens a new bank account.
     *
     * @param a Account object containing customer details
     * @return Generated account number
     */
    public String openAccount(Account a) throws Exception {

        // Validation checks
        if (a.getCustomerId() <= 0)
            throw new RuntimeException("Customer ID is required");

        if (a.getBalance() < 2000)
            throw new RuntimeException("Minimum opening balance is 2000");

        // Generate unique account number
        String accNo = AccountNumberGenerator.generate16Digit();
        a.setAccountNumber(accNo);

        // Persist account
        dao.createAccount(a);

        return accNo;
    }

    /**
     * Fetches account balance.
     *
     * @param accNo Account number
     * @return Current balance
     */
    public double getBalance(String accNo) throws Exception {

        Account a = dao.findByAccountNumber(accNo);

        if (a == null)
            throw new RuntimeException("Account not found");

        return a.getBalance();
    }

    /**
     * Updates account balance.
     *
     * @param accNo Account number
     * @param newBalance Updated balance
     * @return true if update successful
     */
    public boolean updateBalance(String accNo, double newBalance) throws Exception {

        Account a = dao.findByAccountNumber(accNo);

        if (a == null)
            throw new RuntimeException("Account not found");

        return dao.updateBalance(accNo, newBalance);
    }

    /**
     * Closes an account if balance is zero.
     *
     * @param accNo Account number
     */
    public void closeAccount(String accNo) throws Exception {

        Account a = dao.findByAccountNumber(accNo);

        if (a == null)
            throw new RuntimeException("Account not found");

        if (a.getBalance() != 0)
            throw new RuntimeException("Account balance must be ZERO to close");

        dao.closeAccount(accNo);
    }
}
