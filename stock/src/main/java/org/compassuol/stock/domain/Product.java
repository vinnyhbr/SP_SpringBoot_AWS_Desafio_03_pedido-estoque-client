package org.compassuol.order.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long clientId;

    @ElementCollection
    private List<OrderItem> itens;

    @Column(nullable = false)
    private String status;
}
