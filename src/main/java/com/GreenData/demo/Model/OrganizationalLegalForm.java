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

    // Геттер для id
    public int getId() {
        return id;
    }

    // Сеттер для id
    public void setId(int id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }


}
