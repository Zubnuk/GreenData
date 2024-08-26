package com.GreenData.demo.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
@Table(name = "organizational_legal_form")
public class OrganizationalLegalForm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;


    public OrganizationalLegalForm( String name) {
        this.name = name;
    }
    public OrganizationalLegalForm() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}
