package com.GreenData.demo.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "address")
    private String address;
    @Column(name = "idOrganizational")
    private int organizationalLegalFormId;

    public Client( String name, String shortName, String address, int organizationalLegalFormId) {
        this.name = name;
        this.shortName = shortName;
        this.address = address;
        this.organizationalLegalFormId = organizationalLegalFormId;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrganizationalLegalFormId() {
        return organizationalLegalFormId;
    }

    public void setOrganizationalLegalFormId(int organizationalLegalFormId) {
        this.organizationalLegalFormId = organizationalLegalFormId;
    }
}

