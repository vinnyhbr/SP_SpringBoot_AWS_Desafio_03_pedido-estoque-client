package org.compassuol.order.service;

import lombok.RequiredArgsConstructor;
import org.compassuol.order.model.Order;
import org.compassuol.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    public Order createOrder(Order order) {

        String stockUrl = "http://stock:8080/stock/validate";
        Boolean inStock = restTemplate.postForObject(stockUrl, order.getItens(), Boolean.class);

        if (!inStock) {
            throw new RuntimeException("Insufficient inventory to create the order.");
        }

        order.setStatus("CREATED");
        return orderRepository.save(order);
    }
    public List<Order> searchOrdersByCustomer(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }
}
