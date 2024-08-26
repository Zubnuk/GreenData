package com.GreenData.demo.Repository.Interface;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Integer> , JpaSpecificationExecutor<Deposit> {
    boolean existsById(int id);
}