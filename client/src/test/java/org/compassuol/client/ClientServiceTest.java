package org.compassuol.client;

import org.compassuol.client.domain.Client;
import org.compassuol.client.repository.ClientRepository;
import org.compassuol.client.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public ClientServiceTest {
    private final ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
    private final ClientService clientService = new ClientService(clientRepository);

    @Test
    void shouldFindClienteById() {
        // Arrange
        Client client = new Client(1L,"João Silva", "joao.silva@email.com");
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // Act
        Client result = clientService.findClientByEmail(client.getEmail());

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getNome()).isEqualTo("João Silva");
        assertThat(result.getEmail()).isEqualTo("joao.silva@email.com");
        verify(clientRepository, Mockito.times(1));
    }
}
