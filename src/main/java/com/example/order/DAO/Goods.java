package com.example.order.DAO;

import jakarta.persistence.*;

@Entity
@Table(name="GOODS")
public class Goods {
    @Id
    private Long id;
    private String name;
    private Double price;

    public Goods(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Goods() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String toString(){
        return this.id + " " + this.name + " " + this.price;
    }
}
