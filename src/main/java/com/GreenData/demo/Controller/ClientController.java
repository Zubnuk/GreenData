package com.GreenData.demo.Controller;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.Client;
import com.GreenData.demo.Model.Deposit;
import com.GreenData.demo.Service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> findAllStudent() {
        //todo
        return service.findAllClients();
    }

    @PostMapping("save_client")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        Client savedClient = service.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id) {
        Client client = service.findById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("update_client/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client,@PathVariable int id) {
        Client updateClient = service.updateClient(id, client);
        if (updateClient != null) {
            return ResponseEntity.ok(updateClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete_client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable int id) {
        if (service.clientExists(id)) {
            service.deleteClient(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/filter")
    public List<Client> filterClient(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String shortName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) int organizationalLegalFormId,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
        return service.filterClients(name, shortName,address,organizationalLegalFormId, sortBy, order);
    }

}







