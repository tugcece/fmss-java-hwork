package com.patika.ordermanager;

import com.patika.ordermanager.model.Customer;
import com.patika.ordermanager.model.Invoice;
import com.patika.ordermanager.model.Order;
import com.patika.ordermanager.service.CustomerService;
import com.patika.ordermanager.service.InvoiceService;
import com.patika.ordermanager.service.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class OrderManagerApplication {

    public static void main(String[] args) {
        InvoiceService invoiceService = new InvoiceService();
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService(orderService, invoiceService);


        // Prepare customer...
        Customer customer1 = new Customer("tugce","finance");
        Customer customer2 = new Customer("ece","software");
        Customer customer3 = new Customer ("ali","education");
        Customer customer4 = new Customer("veli","security");
        //create customer...
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);
        customerService.addCustomer(customer4);
        //prepare order and add...
        Order order1 = new Order(1, LocalDate.of(2024, 7, 15), 300);
        Order order2 = new Order(2, LocalDate.of(2024, 6, 15), 700);
        Order order3 = new Order(3, LocalDate.of(2024, 6, 15), 700);
        orderService.save(order1);
        orderService.save(order2);
        orderService.save(order3);
        //add order to customer...
        customerService.addOrderToCustomer("Alice", order1);
        customerService.addOrderToCustomer("Alice", order2);
        customerService.addOrderToCustomer("Bob", order3);
        //prepare invoice and add ...
        Invoice invoice1 = new Invoice(1200, LocalDate.of(2024, 6, 15), 1);
        Invoice invoice2 = new Invoice(200, LocalDate.of(2024, 5, 10), 2);
        Invoice invoice3 = new Invoice(2000, LocalDate.of(2024, 6, 20), 3);
        customerService.addInvoiceToCustomer("Alice", invoice1);
        customerService.addInvoiceToCustomer("Alice", invoice2);
        customerService.addInvoiceToCustomer("Bob", invoice3);

        System.out.println("Tüm müşteriler:");
        customerService.getAllCustomers().forEach(c -> System.out.println(c.getName()));

        System.out.println("İçerisinde 'C' harfi olan müşteriler:");
        customerService.getCustomersContainingC().forEach(c -> System.out.println(c.getName()));

        System.out.println("Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı:");
        System.out.println(invoiceService.getTotalInvoiceAmountInJune());

        System.out.println("Sistemdeki tüm faturalar:");
        invoiceService.getAll().forEach(i -> System.out.println(i.getAmount()));

        System.out.println("Sistemdeki 1500TL üstündeki faturalar:");
        invoiceService.getInvoicesAbove1500().forEach(i -> System.out.println(i.getAmount()));

        System.out.println("Sistemdeki 1500TL üstündeki faturaların ortalaması:");
        System.out.println(invoiceService.getAverageInvoiceAbove1500());

        System.out.println("Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri:");
        customerService.getCustomerNamesWithInvoicesBelow500().forEach(System.out::println);

        System.out.println("Haziran ayının faturalarının ortalaması 750 altı olan firmaların sektörleri:");
        customerService.getSectorsWithJuneInvoicesBelow750().forEach(System.out::println);

        System.out.println("Tüm siparişler:");
        orderService.getAllOrders().forEach(o -> System.out.println("Order ID: " + o.getOrderId() + ", Total Amount: " + o.getTotalAmount()));

        System.out.println("1500TL üstündeki siparişler:");
        orderService.getOrdersAboveAmount(1500).forEach(o -> System.out.println("Order ID: " + o.getOrderId() + ", Total Amount: " + o.getTotalAmount()));
    }

}
