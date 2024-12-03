package org.compassuol.order.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderItem {

    private Long productId;
    private int quantity;
}
