package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BankControllerTest {

    @InjectMocks
    private BankController controller;

    @Mock
    private BankService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllBanks() {
        Bank bank1 = new Bank("Bank1", "123456");
        Bank bank2 = new Bank("Bank2", "654321");
        List<Bank> banks = Arrays.asList(bank1, bank2);

        when(service.findAllBanks()).thenReturn(banks);

        List<Bank> result = controller.findAllBanks();

        assertEquals(2, result.size());
        assertEquals("Bank1", result.get(0).getName());
        assertEquals("Bank2", result.get(1).getName());
    }

    @Test
    void testSaveBank() {
        Bank bank = new Bank("Bank3", "987654");
        when(service.saveBank(any(Bank.class))).thenReturn(bank);

        ResponseEntity<Bank> response = controller.saveBank(bank);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Bank3", response.getBody().getName());
    }

    @Test
    void testFindById() {
        Bank bank = new Bank("Bank4", "111222");
        when(service.findById(anyInt())).thenReturn(bank);

        ResponseEntity<Bank> response = controller.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Bank4", response.getBody().getName());
    }

    @Test
    void testUpdateBank() {
        Bank bank = new Bank("Bank5", "333444");
        when(service.updateBank(anyInt(), any(Bank.class))).thenReturn(bank);

        ResponseEntity<Bank> response = controller.updateBank(bank, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Bank5", response.getBody().getName());
    }

    @Test
    void testDeleteBank() {
        doNothing().when(service).deleteBank(anyInt());

        ResponseEntity<Void> response = controller.deleteBank(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).deleteBank(1);
    }

    @Test
    void testFilterBanks() {
        Bank bank = new Bank("Bank6", "555666");
        List<Bank> banks = Arrays.asList(bank);

        when(service.filterBanks(anyString(), anyString(), anyString(), anyString())).thenReturn(banks);

        List<Bank> result = controller.filterBanks("Bank6", "555666", "name", "asc");

        assertEquals(1, result.size());
        assertEquals("Bank6", result.get(0).getName());
    }
}

