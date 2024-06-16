package com.patika.ordermanager.model;

import java.time.LocalDate;

public class Order {
    private final int orderId;
    private final LocalDate orderDate;
    private final double totalAmount;

    public Order(int orderId, LocalDate orderDate, double totalAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
