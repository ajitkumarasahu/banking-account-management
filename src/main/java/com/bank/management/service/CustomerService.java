package com.bank.management.service;

import com.bank.management.dao.CustomerDAO;
import com.bank.management.model.Customer;

/**
 * Service layer responsible for handling
 * business logic related to customers.
 */
public class CustomerService {

    private CustomerDAO dao = new CustomerDAO();

    /**
     * Creates a new customer after validating input.
     *
     * @param c Customer object
     * @return true if customer is created successfully
     */
    public boolean createCustomer(Customer c) throws Exception {

        if (c.getName() == null || c.getName().isEmpty())
            throw new RuntimeException("Name is mandatory");

        if (!c.getEmail().contains("@"))
            throw new RuntimeException("Invalid email format");

        return dao.save(c);
    }

    /**
     * Fetches a customer by ID.
     *
     * @param id Customer ID
     * @return Customer object
     */
    public Customer getCustomer(int id) throws Exception {
        return dao.findById(id);
    }

    /**
     * Fetches all customers.
     *
     * @return List of customers
     */
    public java.util.List<Customer> getAllCustomers() throws Exception {
        return dao.findAll();
    }

    /**
     * Updates customer details after validation.
     *
     * @param c Customer object
     * @return true if update is successful
     */
    public boolean updateCustomer(Customer c) throws Exception {

        if (c.getCustomerId() <= 0)
            throw new RuntimeException("Customer ID is required");

        if (c.getName() == null || c.getName().trim().length() < 3)
            throw new RuntimeException("Name must be at least 3 characters");

        if (!c.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new RuntimeException("Invalid email format");

        if (!c.getPhone().matches("\\d{10}"))
            throw new RuntimeException("Phone number must be 10 digits");

        return dao.update(c);
    }

    /**
     * Deletes a customer using customer ID.
     *
     * @param id Customer ID
     * @return true if deletion is successful
     */
    public boolean deleteCustomer(int id) throws Exception {
        return dao.delete(id);
    }
}
