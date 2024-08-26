package com.GreenData.demo.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
@Table(name = "deposit")
public class Deposit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idClient")
    private int clientId;
    @Column(name = "idBank")
    private int bankId;
    @Column(name = "date")
    private Date openDate;
    @Column(name = "percent")
    private float percent;
    @Column(name = "months")
    private int months;

    public Deposit(int clientId, int bankId, Date openDate, float percent, int months) {
        this.clientId = clientId;
        this.bankId = bankId;
        this.openDate = openDate;
        this.percent = percent;
        this.months = months;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }
}
