package com.GreenData.demo.Service;

import com.GreenData.demo.Model.OrganizationalLegalForm;
import com.GreenData.demo.Repository.Interface.IOrganizationalLegalFormRepository;
import com.GreenData.demo.Service.Interface.IOrganizationalLegalFormService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationalLegalFormService implements IOrganizationalLegalFormService {
    private final IOrganizationalLegalFormRepository repository;

    public OrganizationalLegalFormService (IOrganizationalLegalFormRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<OrganizationalLegalForm> findAllOrganizationalLegalForms() {
        return repository.findAll();
    }

    @Override
    public OrganizationalLegalForm saveOrganizationalLegalForm(OrganizationalLegalForm organizationalLegalForm) {
        return repository.save(organizationalLegalForm);
    }

    @Override
    public OrganizationalLegalForm findById(int id) {
        return repository.getById(id);
    }

    @Override
    public OrganizationalLegalForm updateOrganizationalLegalForm(int id, OrganizationalLegalForm organizationalLegalForm) {
        organizationalLegalForm.setId(id);
        return repository.save(organizationalLegalForm);
    }


    @Override
    public void deleteOrganizationalLegalForm(int id) {
        repository.deleteById(id);

    }
    public boolean organizationalLegalFormExists(int id) {
        return repository.existsById(id);
    }
}
