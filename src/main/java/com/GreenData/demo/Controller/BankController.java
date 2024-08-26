package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.Client;
import com.GreenData.demo.Service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
public class BankController {
    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bank> findAllBanks() {
        return service.findAllBanks();
    }

    @PostMapping("save_bank")
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank) {
        Bank savedBank = service.saveBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBank);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> findById(@PathVariable int id) {
        Bank bank = service.findById(id);
        if (bank != null) {
            return ResponseEntity.ok(bank);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("update_bank/{id}")
    public ResponseEntity<Bank> updateBank(@RequestBody Bank bank, @PathVariable int id) {
        Bank updatedBank = service.updateBank(id, bank);
        if (updatedBank != null) {
            return ResponseEntity.ok(updatedBank);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bank/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable("id") int id) {
        if (service.bankExists(id)) {
            service.deleteBank(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/filter")
    public List<Bank> filterBanks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String bik,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
        return service.filterBanks(name, bik, sortBy, order);
    }
}




