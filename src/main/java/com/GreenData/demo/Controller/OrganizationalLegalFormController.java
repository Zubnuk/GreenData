package com.GreenData.demo.Controller;


import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.Deposit;
import com.GreenData.demo.Model.OrganizationalLegalForm;
import com.GreenData.demo.Service.BankService;
import com.GreenData.demo.Service.OrganizationalLegalFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizationalLegalForms")
public class OrganizationalLegalFormController {
    private final OrganizationalLegalFormService service;

    public OrganizationalLegalFormController(OrganizationalLegalFormService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrganizationalLegalForm> findAllStudent() {
        //todo
        return service.findAllOrganizationalLegalForms();
    }

    @PostMapping("save_organizationalLegalForm")
    public ResponseEntity saveOrganizationalLegalForm(@RequestBody OrganizationalLegalForm organizationalLegalForm) {
        OrganizationalLegalForm organizationalLegalForm1= service.saveOrganizationalLegalForm(organizationalLegalForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationalLegalForm1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationalLegalForm> findById(@PathVariable int id) {
        OrganizationalLegalForm organizationalLegalForm = service.findById(id);
        if (organizationalLegalForm != null) {
            return ResponseEntity.ok(organizationalLegalForm);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @PutMapping("update_organizationalLegalForm")
    public ResponseEntity<OrganizationalLegalForm> updateOrganizationalLegalForm(@RequestBody OrganizationalLegalForm organizationalLegalForm,int id) {
        OrganizationalLegalForm organizationalLegalForm1 = service.updateOrganizationalLegalForm(id, organizationalLegalForm);
        if (organizationalLegalForm1 != null) {
            return ResponseEntity.ok(organizationalLegalForm1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete_organizationalLegalForm/{id}")
    public ResponseEntity<Void> deleteOrganizationalLegalForm(@PathVariable int id) {

        if (service.organizationalLegalFormExists(id)) {
            service.deleteOrganizationalLegalForm(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}











