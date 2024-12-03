package org.compassuol.client.client;

import lombok.RequiredArgsConstructor;
import org.compassuol.client.domain.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceClient {

    private final RestTemplate restTemplate;


    public List<OrderDTO> searchOrdersByCustomer(Long clientId) {
        String url = "http://localhost:8081/orders/client/" + clientId;
        OrderDTO[] orders = restTemplate.getForObject(url, OrderDTO[].class);
        return Arrays.asList(orders);
    }
}
