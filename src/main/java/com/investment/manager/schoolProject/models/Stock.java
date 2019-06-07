package com.investment.manager.schoolProject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId() {
        this.id = id;
    }

    public double price;
    @Id
    public Long id;
}
