package com.GreenData.demo.Repository.Interface;

import com.GreenData.demo.Model.Bank;
import com.GreenData.demo.Model.OrganizationalLegalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganizationalLegalFormRepository extends JpaRepository<OrganizationalLegalForm, Integer>, JpaSpecificationExecutor<OrganizationalLegalForm> {
    boolean existsById(int id);
}
