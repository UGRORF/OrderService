package com.example.order.DAO;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    private Long id;
//    @Column(name="`CLIENT`")
    private String client;
//    @Column(name="`DATE`")
    private Date date;
//    @Column(name="`ADDRESS`")
    private String address;

    public Order() {
    }

    public Order(Long id, String client, Date date, String address) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.address = address;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
