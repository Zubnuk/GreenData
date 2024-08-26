package com.GreenData.demo.Service;


import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Repository.Interface.IBankRepository;
import com.GreenData.demo.Service.Interface.IBankService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class BankService implements IBankService {
    private  final IBankRepository repository;

    public BankService(IBankRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Bank> findAllBanks() {
        return repository.findAll();
    }

    @Override
    public Bank saveBank(Bank bank) {
        return repository.save(bank);
    }

    @Override
    public Bank findById(int id) {
        return repository.getById(id);
    }

    @Override
    public Bank updateBank(int id, Bank bank) {
        bank.setId(id);
        return repository.save(bank);
    }



    @Override
    public void deleteBank(int id) {
        repository.deleteById(id);

    }
    @Override
    public List<Bank> filterBanks(String name, String bik, String sortBy, String order) {

        Specification<Bank> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("name"), "%" + name + "%"));
        }
        if (bik != null && !bik.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("bik"), bik));
        }

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortBy);
        return repository.findAll(spec, sort);
    }
    public boolean bankExists(int id) {
        return repository.existsById(id);
    }

}
