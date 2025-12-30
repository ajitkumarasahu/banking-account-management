package com.bank.management.dao;

import com.bank.management.model.Customer;
import com.bank.management.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class responsible for performing CRUD operations
 * on the Customer table.
 */
public class CustomerDAO {

    /**
     * Saves a new customer into the database.
     *
     * @param c Customer object
     * @return true if insertion is successful
     */
    public boolean save(Customer c) throws Exception {

        String sql = "INSERT INTO customers(name, email, phone, address, username, password) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getPhone());
        ps.setString(4, c.getAddress());
        ps.setString(5, c.getUsername());
        ps.setString(6, c.getPassword());

        return ps.executeUpdate() > 0;
    }

    /**
     * Retrieves a customer using customer ID.
     *
     * @param id Customer ID
     * @return Customer object or null if not found
     */
    public Customer findById(int id) throws Exception {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Customer c = new Customer();
            c.setCustomerId(rs.getInt("customer_id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            c.setAddress(rs.getString("address"));
            c.setUsername(rs.getString("username"));
            c.setStatus(rs.getString("status"));
            return c;
        }
        return null;
    }

    /**
     * Fetches customer by username.
     *
     * @param username Username
     * @return Customer object if found
     */
    public Customer findByUsername(String username) throws Exception {

        String sql = "SELECT * FROM customers WHERE username = ?";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Customer c = new Customer();
            c.setCustomerId(rs.getInt("customer_id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            c.setAddress(rs.getString("address"));
            c.setUsername(rs.getString("username"));
            c.setStatus(rs.getString("status"));
            return c;
        }
        return null;
    }

    /**
     * Fetches all customers from database.
     *
     * @return List of customers
     */
    public List<Customer> findAll() throws Exception {

        List<Customer> list = new ArrayList<>();

        ResultSet rs = DBUtil.getConnection()
                .prepareStatement("SELECT * FROM customers")
                .executeQuery();

        while (rs.next()) {
            Customer c = new Customer();
            c.setCustomerId(rs.getInt("customer_id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            c.setAddress(rs.getString("address"));
            c.setUsername(rs.getString("username"));
            c.setStatus(rs.getString("status"));
            list.add(c);
        }
        return list;
    }

    /**
     * Updates customer details.
     *
     * @param c Customer object with updated data
     * @return true if update is successful
     */
    public boolean update(Customer c) throws Exception {

        String sql = "UPDATE customers SET name=?, email=?, phone=?, address=?, username=?, password=? " +
                     "WHERE customer_id=?";

        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getPhone());
        ps.setString(4, c.getAddress());
        ps.setString(5, c.getUsername());
        ps.setString(6, c.getPassword());
        ps.setInt(7, c.getCustomerId());

        return ps.executeUpdate() > 0;
    }

    /**
     * Deletes a customer by ID.
     *
     * @param id Customer ID
     * @return true if deleted successfully
     */
    public boolean delete(int id) throws Exception {

        PreparedStatement ps = DBUtil.getConnection()
                .prepareStatement("DELETE FROM customers WHERE customer_id=?");

        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
}
