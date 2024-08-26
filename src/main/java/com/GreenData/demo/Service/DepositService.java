package com.GreenData.demo.Service;
import com.GreenData.demo.Model.Deposit;
import com.GreenData.demo.Repository.Interface.IDepositRepository;
import com.GreenData.demo.Service.Interface.IDepositService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class DepositService implements IDepositService {
    private final IDepositRepository repository;

    public DepositService(IDepositRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Deposit> findAllDeposits() {
        return repository.findAll();
    }

    @Override
    public Deposit saveDeposit(Deposit deposit) {
        return repository.save(deposit);
    }

    @Override
    public Deposit findById(int id) {
        return repository.getById(id);
    }

    @Override
    public Deposit updateDeposit(int id, Deposit deposit) {
        deposit.setId(id);
        return repository.save(deposit);
    }



    @Override
    public void deleteDeposit(int id) {
        repository.deleteById(id);

    }
    @Override
    public List<Deposit> filterDeposits(Integer clientId, Integer bankId, Date openDate, Float percent, Integer months, String sortBy, String order) {
        // Логика для фильтрации и сортировки
        Specification<Deposit> spec = Specification.where(null);

        if (clientId != null && clientId > 0) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("clientId"), clientId));
        }
        if (bankId != null && bankId > 0) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("bankId"), bankId));
        }
        if (openDate != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("openDate"), openDate));
        }
        if (percent != null && percent > 0) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("percent"), percent));
        }
        if (months != null && months > 0) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("months"), months));
        }

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortBy);
        return repository.findAll(spec, sort);
    }
    public boolean depositExists(int id) {
        return repository.existsById(id);  // Используем стандартный метод репозитория для проверки существования
    }

}
