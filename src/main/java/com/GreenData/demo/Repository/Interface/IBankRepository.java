package com.GreenData.demo.Repository.Interface;

import com.GreenData.demo.Model.Bank;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBankRepository extends JpaRepository<Bank, Integer>, JpaSpecificationExecutor<Bank> {
    boolean existsById(int id);
}