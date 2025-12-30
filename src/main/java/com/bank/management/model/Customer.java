package com.bank.management.model;

/**
 * Model class representing a Customer.
 * This class holds customer-related data and
 * is used across Controller, Service, and DAO layers.
 */
public class Customer {

    /** Unique identifier for the customer */
    private int customerId;

    /** Full name of the customer */
    private String name;

    /** Email address of the customer */
    private String email;

    /** Contact number */
    private String phone;

    /** Residential address */
    private String address;

    /** Login username */
    private String username;

    /** Login password (should be encrypted in production) */
    private String password;

    /** Customer status (ACTIVE / INACTIVE) */
    private String status;

    // -------------------- Getters and Setters --------------------

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Sets customer password.
     * ⚠️ In production, password should always be encrypted.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
