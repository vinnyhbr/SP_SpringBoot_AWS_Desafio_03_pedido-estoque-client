package org.compassuol.order.controller;

import lombok.RequiredArgsConstructor;
import org.compassuol.order.model.Order;
import org.compassuol.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Order>> searchOrdersByCustomer(@PathVariable Long clientId) {
        return ResponseEntity.ok(orderService.searchOrdersByCustomer(clientId));
    }

}
