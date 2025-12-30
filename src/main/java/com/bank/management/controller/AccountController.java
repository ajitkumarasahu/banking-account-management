package com.bank.management.controller;

import com.bank.management.model.Account;
import com.bank.management.service.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Controller responsible for handling all account-related operations.
 * Exposes APIs to open, close, and fetch account details.
 */
@Path("/accounts")
public class AccountController {

    // Service layer object to handle business logic
    private AccountService service = new AccountService();

    /**
     * Opens a new bank account.
     *
     * @param a Account object received in JSON format
     * @return JSON response containing account number or error message
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String open(Account a) {
        try {
            String accNo = service.openAccount(a);
            return "{\"message\":\"Account Opened Successfully\",\"accountNumber\":\"" + accNo + "\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Closes an existing account using account number.
     *
     * @param accNo Account number to be closed
     * @return Success or error message
     */
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/{accNo}/close")
    public String closeAccount(@PathParam("accNo") String accNo) {
        try {
            service.closeAccount(accNo);
            return "{\"message\":\"Account Closed Successfully\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Fetches account balance for a given account number.
     *
     * @param accNo Account number
     * @return JSON containing account number and balance
     */
    @GET
    @Path("/{accNo}/balance")
    @Produces(MediaType.APPLICATION_JSON)
    public String balance(@PathParam("accNo") String accNo) throws Exception {
        double bal = service.getBalance(accNo);
        return "{\"accountNumber\":\"" + accNo + "\",\"balance\":" + bal + "}";
    }

    /**
     * Deletes (closes) an account permanently.
     *
     * @param accNo Account number
     * @return Success or error message
     */
    @DELETE
    @Path("/{accNo}")
    public String close(@PathParam("accNo") String accNo) {
        try {
            service.closeAccount(accNo);
            return "{\"message\":\"Account Closed Successfully\",\"accountNumber\":\"" + accNo + "\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }
}
