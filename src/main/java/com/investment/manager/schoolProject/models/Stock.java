package com.investment.manager.schoolProject.models;

import com.investment.manager.schoolProject.domain.RandomHistory;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Random;

@Entity
public class Stock implements RandomHistory {

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
    public double[] history = new double[20];
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    public Stock (){
        generateRandomHistory();
    }
    public Stock (double price, String ticker){
        this.ticker = ticker;
        this.price = price;
        generateRandomHistory();
    }

    public void generateRandomHistory() {
        Random r = new Random();
        double historyStartingPoint = price;
        history[0] = historyStartingPoint;
        for (int i = 1; i < history.length; i++) {
            history[i]=history[i-1];
            double randomValue = r.nextGaussian();
            if(randomValue<0) randomValue*=-1;
            if(randomValue<0.03) randomValue*=10;
            history[i] = Math.round(randomValue*1.8*history[i]);
        }
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