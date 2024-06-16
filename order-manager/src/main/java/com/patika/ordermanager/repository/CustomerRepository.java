package com.patika.ordermanager.repository;

import com.patika.ordermanager.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Optional<Customer> getCustomerByName(String name) {
        return customers.stream()
                .filter(customer -> customer.getName().equals(name))
                .findFirst();
    }
}
