package com.patika.ordermanager.model;

import java.time.LocalDate;

public class Invoice {
    private final double amount;
    private final LocalDate date;
    private final int orderId;

    public Invoice(double amount, LocalDate date, int orderId) {
        this.amount = amount;
        this.date = date;
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}

