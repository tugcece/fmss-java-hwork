package com.patika.ordermanager.service;

import com.patika.ordermanager.model.Customer;
import com.patika.ordermanager.model.Invoice;
import com.patika.ordermanager.model.Order;
import com.patika.ordermanager.repository.CustomerRepository;
import com.patika.ordermanager.repository.InvoiceRepository;

import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final InvoiceService invoiceService;
    private final OrderService orderService;

    public CustomerService(OrderService orderService, InvoiceService invoiceService) {
        this.orderService = orderService;
        this.invoiceService = invoiceService;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public void addInvoiceToCustomer(String customerName, Invoice invoice) {
        customerRepository.getCustomerByName(customerName).ifPresent(customer -> {
            customer.addInvoice(invoice);
            invoiceService.save(invoice);
        });
    }

    public void addOrderToCustomer(String customerName, Order order) {
        customerRepository.getCustomerByName(customerName).ifPresent(customer -> {
            customer.addOrder(order);
            orderService.save(order);
        });
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public List<Customer> getCustomersContainingC() {
        return customerRepository.getAllCustomers().stream()
                .filter(customer -> customer.getName().toLowerCase(Locale.ROOT).contains("c"))
                .collect(Collectors.toList());
    }

    public List<String> getCustomerNamesWithInvoicesBelow500() {
        return customerRepository.getAllCustomers().stream()
                .filter(customer -> customer.getInvoices().stream().anyMatch(invoice -> invoice.getAmount() < 500))
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    public List<String> getSectorsWithJuneInvoicesBelow750() {
        return customerRepository.getAllCustomers().stream()
                .filter(customer -> customer.getInvoices().stream()
                        .filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
                        .mapToDouble(Invoice::getAmount)
                        .average()
                        .orElse(0) < 750)
                .map(Customer::getSector)
                .distinct()
                .collect(Collectors.toList());
    }


}
