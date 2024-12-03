package org.compassuol.client.controller;

import lombok.RequiredArgsConstructor;
import org.compassuol.client.client.OrderServiceClient;
import org.compassuol.client.domain.Client;
import org.compassuol.client.domain.dto.OrderDTO;
import org.compassuol.client.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final OrderServiceClient orderServiceClient;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/{email}")
    public Client findClientByEmail(@PathVariable String email) {
        return clientService.findClientByEmail(email);
    }

    @GetMapping
    public List<Client> listAllClients() {
        return clientService.listAllClients();
    }
    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderDTO>> searchCustomerOrders(@PathVariable Long id) {
        List<OrderDTO> orders = orderServiceClient.searchOrdersByCustomer(id);
        return ResponseEntity.ok(orders);
    }


}
