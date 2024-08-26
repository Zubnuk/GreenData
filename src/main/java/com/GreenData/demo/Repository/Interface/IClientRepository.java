package com.GreenData.demo.Repository.Interface;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> , JpaSpecificationExecutor<Client> {
    boolean existsById(int id);
}