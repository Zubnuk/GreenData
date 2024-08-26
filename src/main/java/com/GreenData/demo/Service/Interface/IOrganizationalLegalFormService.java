package com.GreenData.demo.Service.Interface;


import com.GreenData.demo.Model.OrganizationalLegalForm;

import java.util.List;

public interface IOrganizationalLegalFormService {
    List<OrganizationalLegalForm> findAllOrganizationalLegalForms();
    OrganizationalLegalForm saveOrganizationalLegalForm(OrganizationalLegalForm organizationalLegalForm);
    OrganizationalLegalForm findById(int id);
    OrganizationalLegalForm updateOrganizationalLegalForm(int id,OrganizationalLegalForm organizationalLegalForm);
    void deleteOrganizationalLegalForm(int id);
}
