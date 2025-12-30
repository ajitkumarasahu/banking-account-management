package com.bank.management.controller;

import com.bank.management.model.Customer;
import com.bank.management.service.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Controller responsible for handling all customer-related operations.
 * Provides APIs for creating, retrieving, updating, and deleting customers.
 */
@Path("/customers")
public class CustomerController {

    // Service layer instance for business logic
    private CustomerService service = new CustomerService();

    /**
     * Creates a new customer.
     *
     * @param c Customer object received in JSON format
     * @return Success or error message in JSON
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Customer c) {
        try {
            service.createCustomer(c);
            return "{\"message\":\"Customer Created Successfully\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Fetches a customer by ID.
     *
     * @param id Customer ID
     * @return Customer object in JSON format
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer get(@PathParam("id") int id) throws Exception {
        return service.getCustomer(id);
    }

    /**
     * Fetches all customers.
     *
     * @return List of customers
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAll() throws Exception {
        return service.getAllCustomers();
    }

    /**
     * Updates customer details using customer ID.
     *
     * @param id Customer ID
     * @param c  Updated customer object
     * @return Success or error message
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("id") int id, Customer c) {
        try {
            c.setCustomerId(id); // Ensure correct ID is updated
            service.updateCustomer(c);
            return "{\"message\":\"Customer Updated Successfully\"}";
        } catch (Exception e) {
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    /**
     * Deletes a customer using customer ID.
     *
     * @param id Customer ID
     * @return Success message
     */
    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") int id) throws Exception {
        service.deleteCustomer(id);
        return "{\"message\":\"Customer Deleted Successfully\"}";
    }
}
