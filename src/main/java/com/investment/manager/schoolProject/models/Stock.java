package com.investment.manager.schoolProject.models;

import javax.persistence.*;

@Entity
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

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String ticker;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    public Stock (){}
    public Stock (double price, String ticker){
        this.ticker = ticker;
        this.price = price;
    }
}













/*




package com.investment.manager.schoolProject.models;

import javax.persistence.*;

@Entity
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

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String ticker;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;


    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn (name="stock",referencedColumnName="id",nullable = false,unique=true)
    public Portfolio portfolio;

//    public Portfolio getPortfolio(){
//        return portfolio;
//    }
//    public void setPortfolio(Portfolio portfolio){
//        this.portfolio = portfolio;
//    }

    public Stock (){}
    public Stock (double price, String ticker){
        this.ticker = ticker;
        this.price = price;
    }
}





 */