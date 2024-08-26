package com.GreenData.demo.Service;


import com.GreenData.demo.Model.Client;
import com.GreenData.demo.Repository.Interface.IClientRepository;
import com.GreenData.demo.Service.Interface.IClientService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ClientService implements IClientService {
    private final IClientRepository repository;

    public ClientService(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findById(int id) {
        return repository.getById(id);
    }



    @Override
    public Client updateClient(int id,Client client) {
        client.setId(id);
        return repository.save(client);
    }

    @Override
    public void deleteClient(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> filterClients(String name, String shortName, String address, int organizationalLegalFormId, String sortBy, String order) {
        // Логика для фильтрации и сортировки
        Specification<Client> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("name"), "%" + name + "%"));
        }
        if (shortName != null && !shortName.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("shortName"), "%" + shortName + "%"));
        }
        if (address != null && !address.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("address"), "%" + address + "%"));
        }
        if (organizationalLegalFormId > 0) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("organizationalLegalFormId"), organizationalLegalFormId));
        }

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortBy);
        return repository.findAll(spec, sort);
    }
    public boolean clientExists(int id) {
        return repository.existsById(id);  // Используем стандартный метод репозитория для проверки существования
    }

}
