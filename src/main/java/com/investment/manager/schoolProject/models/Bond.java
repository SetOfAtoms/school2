package com.investment.manager.schoolProject.models;

import com.investment.manager.schoolProject.domain.RandomHistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

// bond model that includes initialPrice, closingPrice and a issuer.

@Entity
public class Bond  implements RandomHistory {
    public double initialPrice = 100;
    public double closingPrice;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getIssuerName() {
        return issuer;
    }

    public void setIssuerName(String IssuerName) {
        this.issuer = issuer;
    }

    public String issuer;

    public Bond(double initialPrice, double closingPrice, String IssuerName) {
        this.initialPrice = initialPrice;
        this.closingPrice = closingPrice;
        this.issuer = IssuerName;
        generateRandomHistory();
        try {
            this.closingPrice = history[19];
        }catch (Exception ignored){
        }
    }

    public double[] getHistory() {
        return history;
    }

    public void setHistory(double[] history) {
        this.history = history;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public double[] history = new double[20];

    public Bond() {
        generateRandomHistory();
    }

    @Override
    public void generateRandomHistory() {
        Random r = new Random();
        double historyStartingPoint = initialPrice;
        history[0] = historyStartingPoint;
        double rd = Math.abs(r.nextGaussian());
        int ri = r.nextInt(3);
        for (int i = 1; i < history.length; i++) {
            history[i] = Math.round(history[i - 1] + Math.pow(1.002, i + ri) / rd) + i-ri;

        }
    }
}
