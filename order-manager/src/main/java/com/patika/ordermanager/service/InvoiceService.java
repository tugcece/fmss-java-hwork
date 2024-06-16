package com.patika.ordermanager.service;


import com.patika.ordermanager.model.Invoice;
import com.patika.ordermanager.repository.InvoiceRepository;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {

    private final InvoiceRepository invoiceRepository = new InvoiceRepository();

      public void save(Invoice invoice) {
      invoiceRepository.addInvoice(invoice);
    };
    public void addInvoice(Invoice invoice) {
        invoiceRepository.addInvoice(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceRepository.getAllInvoices();
    }

    public List<Invoice> getInvoicesAbove1500() {
        return invoiceRepository.getAllInvoices().stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .collect(Collectors.toList());
    }

    public double getAverageInvoiceAbove1500() {
        return invoiceRepository.getAllInvoices().stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public double getTotalInvoiceAmountInJune() {
        return invoiceRepository.getAllInvoices().stream()
                .filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }


}
