package org.compassuol.client.controller;

import lombok.RequiredArgsConstructor;
import org.compassuol.client.domain.Client;
import org.compassuol.client.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

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


}
