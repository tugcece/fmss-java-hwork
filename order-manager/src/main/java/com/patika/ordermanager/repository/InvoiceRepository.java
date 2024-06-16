package com.patika.ordermanager.repository;

import com.patika.ordermanager.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private final List<Invoice> invoices = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoices;
    }
}
