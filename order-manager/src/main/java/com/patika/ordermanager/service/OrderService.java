package com.patika.ordermanager.service;

import com.patika.ordermanager.model.Order;
import com.patika.ordermanager.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

       public void save(Order order) {
      orderRepository.addOrder(order);
    };

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public List<Order> getOrdersAboveAmount(double amount) {
        return orderRepository.getAllOrders().stream()
                .filter(order -> order.getTotalAmount() > amount)
                .collect(Collectors.toList());
    }
}
