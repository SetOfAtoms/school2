package com.investment.manager.schoolProject.models;

import com.investment.manager.schoolProject.domain.RandomHistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

// stock model that includes price and a ticker.


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

    public double price = 0;

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
