package com.patika.ordermanager.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String sector;
    private final List<Invoice> invoices;
    private final List<Order> orders;

    public Customer(String name, String sector) {
        this.name = name;
        this.sector = sector;
        this.invoices = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
