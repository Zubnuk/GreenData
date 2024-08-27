package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Deposit;
import com.GreenData.demo.Service.DepositService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class DepositControllerTest {

    @InjectMocks
    private DepositController controller;

    @Mock
    private DepositService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllDeposits() {
        Deposit deposit1 = new Deposit(1, 1, new Date(), 2.5f, 12);
        Deposit deposit2 = new Deposit(2, 2, new Date(), 3.0f, 24);
        List<Deposit> deposits = Arrays.asList(deposit1, deposit2);

        when(service.findAllDeposits()).thenReturn(deposits);

        ResponseEntity<List<Deposit>> response = controller.findAllDeposits();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getClientId());
    }

    @Test
    void testSaveDeposit() {
        Deposit deposit = new Deposit(1, 1, new Date(), 2.5f, 12);
        when(service.saveDeposit(any(Deposit.class))).thenReturn(deposit);

        ResponseEntity<Deposit> response = controller.saveDeposit(deposit);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getClientId());
    }

    @Test
    void testFindById() {
        Deposit deposit = new Deposit(1, 1, new Date(), 2.5f, 12);
        when(service.findById(anyInt())).thenReturn(deposit);

        ResponseEntity<Deposit> response = controller.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getClientId());
    }

    @Test
    void testFindByIdNotFound() {
        when(service.findById(anyInt())).thenReturn(null);

        ResponseEntity<Deposit> response = controller.findById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateDeposit() {
        Deposit deposit = new Deposit(1, 1, new Date(), 2.5f, 12);
        when(service.updateDeposit(anyInt(), any(Deposit.class))).thenReturn(deposit);

        ResponseEntity<Deposit> response = controller.updateDeposit(1, deposit);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getClientId());
    }

    @Test
    void testUpdateDepositNotFound() {
        when(service.updateDeposit(anyInt(), any(Deposit.class))).thenReturn(null);

        ResponseEntity<Deposit> response = controller.updateDeposit(1, new Deposit(1, 1, new Date(), 2.5f, 12));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteDeposit() {
        when(service.depositExists(1)).thenReturn(true);
        doNothing().when(service).deleteDeposit(anyInt());

        ResponseEntity<Void> response = controller.deleteDeposit(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).deleteDeposit(1);
    }


    @Test
    void testFilterDeposits() {
        Deposit deposit = new Deposit(1, 1, new Date(), 2.5f, 12);
        List<Deposit> deposits = Arrays.asList(deposit);

        when(service.filterDeposits(anyInt(), anyInt(), any(Date.class), any(Float.class), anyInt(), any(String.class), any(String.class)))
                .thenReturn(deposits);

        ResponseEntity<List<Deposit>> response = controller.filterDeposits(
                1, 1, new Date(), 2.5f, 12, "id", "asc");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getClientId());
    }
}
