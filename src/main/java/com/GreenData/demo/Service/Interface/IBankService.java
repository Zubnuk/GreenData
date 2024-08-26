package com.GreenData.demo.Service.Interface;

import com.GreenData.demo.Model.Bank;

import java.util.List;

public interface IBankService {
    List<Bank> findAllBanks();
    Bank saveBank(Bank bank);
    Bank findById(int id);
    Bank updateBank(int id,Bank bank);
    void deleteBank(int id);
    public List<Bank> filterBanks(String name, String bik, String sortBy, String order);


}
