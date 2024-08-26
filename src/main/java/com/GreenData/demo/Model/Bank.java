package com.GreenData.demo.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "BIK")
    private String bik;

    // Конструктор без id
    public Bank(String name, String bik) {
        this.name = name;
        this.bik = bik;
    }
    public Bank() {

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

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }
}
