package com.bank.management.controller;

import com.bank.management.service.TransactionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Controller responsible for handling all transaction-related operations
 * such as deposit, withdrawal, and fund transfer.
 */
@Path("/transactions")
public class TransactionController {

    // Service layer instance for transaction operations
    private TransactionService service = new TransactionService();

    /**
     * Deposits amount into an account.
     *
     * @param body JSON input containing account number and amount
     * @return Success or error message
     */
    @POST
    @Path("/deposit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deposit(String body) {
        try {
            // Extract account number and amount from request body
            String accNo = body.split(",")[0].split(":")[1].replace("\"", "").trim();
            double amount = Double.parseDouble(
                    body.split(",")[1].split(":")[1].replace("}", "").trim()
            );

            service.deposit(accNo, amount);
            return "{\"message\":\"Deposit Successful\"}";

        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Withdraws amount from an account.
     *
     * @param body JSON input containing account number and amount
     * @return Success or error message
     */
    @POST
    @Path("/withdraw")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String withdraw(String body) {
        try {
            // Extract account number and amount
            String accNo = body.split(",")[0].split(":")[1].replace("\"", "").trim();
            double amount = Double.parseDouble(
                    body.split(",")[1].split(":")[1].replace("}", "").trim()
            );

            service.withdraw(accNo, amount);
            return "{\"message\":\"Withdraw Successful\"}";

        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Transfers amount from one account to another.
     *
     * @param body JSON input containing source account, destination account, and amount
     * @return Success or error message
     */
    @POST
    @Path("/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String transfer(String body) {
        try {
            // Parse JSON manually
            String[] data = body.replace("{", "")
                                .replace("}", "")
                                .replace("\"", "")
                                .split(",");

            String fromAcc = data[0].split(":")[1].trim();
            String toAcc   = data[1].split(":")[1].trim();
            double amount  = Double.parseDouble(data[2].split(":")[1].trim());

            service.transfer(fromAcc, toAcc, amount);
            return "{\"message\":\"Transfer Successful\"}";

        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }
}
