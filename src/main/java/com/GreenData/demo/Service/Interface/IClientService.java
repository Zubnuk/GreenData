package com.GreenData.demo.Service.Interface;



import com.GreenData.demo.Model.Client;

import java.util.List;

public interface IClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client findById(int id);
    Client updateClient(int id,Client client);
    void deleteClient(int id);


    public List<Client> filterClients(String name, String shortName, String address, int organizationalLegalFormId, String sortBy, String order);


}
