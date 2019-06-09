package com.investment.manager.schoolProject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    public Portfolio(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    @Override
    public String toString(){
        return "Portfolio with id = " + Id.toString();
    }


}








/*

package com.investment.manager.schoolProject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {
    public Portfolio(List<Stock> stocks){
        setStocks(stocks);
    }

    public Portfolio(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;


    @OneToMany(mappedBy = "portfolio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Stock> stocks = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString(){
        return "Portfolio with id = " + Id.toString() + ". Is empty: " + getStocks().isEmpty() + ". Size: "
                + getStocks().size();
    }


}












 */