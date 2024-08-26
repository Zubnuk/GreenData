package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Deposit;
import com.GreenData.demo.Service.DepositService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deposits")
public class DepositController {
    private final DepositService service;

    public DepositController(DepositService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Deposit>> findAllDeposits() {
        List<Deposit> deposits = service.findAllDeposits();
        return ResponseEntity.ok(deposits);
    }

    @PostMapping("/save_deposit")
    public ResponseEntity<Deposit> saveDeposit(@RequestBody Deposit deposit) {
        Deposit savedDeposit = service.saveDeposit(deposit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeposit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposit> findById(@PathVariable int id) {
        Deposit deposit = service.findById(id);
        if (deposit != null) {
            return ResponseEntity.ok(deposit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update_deposit")
    public ResponseEntity<Deposit> updateDeposit(@RequestParam int id, @RequestBody Deposit deposit) {
        Deposit updatedDeposit = service.updateDeposit(id, deposit);
        if (updatedDeposit != null) {
            return ResponseEntity.ok(updatedDeposit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete_deposit/{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable int id) {
        if (service.depositExists(id)) {
            service.deleteDeposit(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/filter")
    public ResponseEntity<List<Deposit>> filterDeposits(
            @RequestParam(required = false) Integer clientId,
            @RequestParam(required = false) Integer bankId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date openDate,
            @RequestParam(required = false) Float percent,
            @RequestParam(required = false) Integer months,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
        List<Deposit> deposits = service.filterDeposits(clientId, bankId, openDate, percent, months, sortBy, order);
        return ResponseEntity.ok(deposits);
    }
}
