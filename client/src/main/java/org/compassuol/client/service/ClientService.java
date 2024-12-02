package org.compassuol.client.service;

import lombok.RequiredArgsConstructor;
import org.compassuol.client.domain.Client;
import org.compassuol.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client saveClient(Client cliente) {
        return clientRepository.save(cliente);
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> listAllClients() {
        return clientRepository.findAll();
    }
}
