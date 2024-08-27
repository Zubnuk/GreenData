package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Client;
import com.GreenData.demo.Service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @InjectMocks
    private ClientController controller;

    @Mock
    private ClientService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllClients() {
        Client client1 = new Client("Client1", "C1", "Address1", 1);
        Client client2 = new Client("Client2", "C2", "Address2", 2);
        List<Client> clients = Arrays.asList(client1, client2);

        when(service.findAllClients()).thenReturn(clients);

        List<Client> result = controller.findAllStudent();

        assertEquals(2, result.size());
        assertEquals("Client1", result.get(0).getName());
        assertEquals("Client2", result.get(1).getName());
    }

    @Test
    void testSaveClient() {
        Client client = new Client("Client3", "C3", "Address3", 3);
        when(service.saveClient(any(Client.class))).thenReturn(client);

        ResponseEntity<Client> response = controller.saveClient(client);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Client3", response.getBody().getName());
    }

    @Test
    void testFindById() {
        Client client = new Client("Client4", "C4", "Address4", 4);
        when(service.findById(anyInt())).thenReturn(client);

        ResponseEntity<Client> response = controller.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Client4", response.getBody().getName());
    }

    @Test
    void testUpdateClient() {
        Client client = new Client("Client5", "C5", "Address5", 5);
        when(service.updateClient(anyInt(), any(Client.class))).thenReturn(client);

        ResponseEntity<Client> response = controller.updateClient(client, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Client5", response.getBody().getName());
    }

    @Test
    void testDeleteClient() {
        when(service.clientExists(1)).thenReturn(true);
        doNothing().when(service).deleteClient(anyInt());

        ResponseEntity<Object> response = controller.deleteClient(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).deleteClient(1);
    }


    @Test
    void testFilterClients() {
        Client client = new Client("Client6", "C6", "Address6", 6);
        List<Client> clients = Arrays.asList(client);

        when(service.filterClients(anyString(), anyString(), anyString(), anyInt(), anyString(), anyString())).thenReturn(clients);

        List<Client> result = controller.filterClient("Client6", "C6", "Address6", 6, "name", "asc");

        assertEquals(1, result.size());
        assertEquals("Client6", result.get(0).getName());
    }
}

