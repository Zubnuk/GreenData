package com.GreenData.demo.Service.Interface;



import com.GreenData.demo.Model.Deposit;

import java.util.Date;
import java.util.List;

public interface IDepositService {
    List<Deposit> findAllDeposits();
    Deposit saveDeposit(Deposit deposit);
    Deposit findById(int id);
    Deposit updateDeposit(int id,Deposit deposit);
    void deleteDeposit(int id);
    public List<Deposit> filterDeposits(Integer clientId, Integer bankId, Date openDate, Float percent, Integer months, String sortBy, String order);

}
