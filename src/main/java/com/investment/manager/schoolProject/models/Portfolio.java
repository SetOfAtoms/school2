package com.investment.manager.schoolProject.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {
//
//    public Portfolio(List<Stock> stocks){
//        this.stocks = stocks;
//    }

    public Portfolio(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

//    public List<Stock> getStocks() {
//        return stocks;
//    }
//
//    public void setStocks(List<Stock> stocks) {
//        this.stocks = stocks;
//    }
//
//    @OneToMany(targetEntity = Stock.class,
//            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public List<Stock> stocks;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
