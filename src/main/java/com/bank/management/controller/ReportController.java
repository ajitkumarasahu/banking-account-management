package com.bank.management.controller;

import com.bank.management.model.Transaction;
import com.bank.management.service.ReportService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST controller responsible for handling report-related APIs.
 * Provides endpoints for transaction history and administrative summary.
 */
@Path("/reports")
public class ReportController {

    // Service layer for report operations
    ReportService service = new ReportService();

    /**
     * Fetches transaction history for a given account number.
     *
     * @param accNo Account number whose transaction history is requested
     * @return List of Transaction objects
     * @throws Exception if account does not exist or database error occurs
     */
    @GET
    @Path("/history/{accNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> history(@PathParam("accNo") String accNo) throws Exception {
        return service.history(accNo);
    }

    /**
     * Returns administrative summary details.
     * Includes total number of customers and total deposited amount.
     *
     * @return JSON string containing summary information
     * @throws Exception if data retrieval fails
     */
    @GET
    @Path("/admin/summary")
    @Produces(MediaType.APPLICATION_JSON)
    public String summary() throws Exception {
        return service.adminSummary();
    }
}
