package com.investment.manager.schoolProject;


import com.investment.manager.schoolProject.models.Bond;
import com.investment.manager.schoolProject.models.Stock;
import com.investment.manager.schoolProject.repositories.AssetsRepository;
import com.investment.manager.schoolProject.repositories.BondRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MainTests {


    @Autowired
    AssetsRepository repository;

    @Autowired
    public BondRepository bondRepository;

    // test adding a bond
    @Test
    public void addBond(){
        final String issuer = "Band of America";
        Bond testBond = new Bond(100, 114.5, issuer);
        bondRepository.save(testBond);
        Bond lastBond = null;
        for (int i = 0; i < bondRepository.count(); i++) {
            if(!bondRepository.findAll().iterator().hasNext()){
                lastBond = bondRepository.findAll().iterator().next();
            }
        }
        if(lastBond!=null)
        assert (lastBond.equals(testBond));

    }
    // test JPA adding ability
    @Test
    public void isJPAWorking() {
        List<Stock> stockList = (List<Stock>) repository.findAll();
        assert stockList.get(0).ticker.equals("AAPL");
    }

    // test what happen if we add exactly the same stock
    @Test
    public void addSameStock() {
        List<Stock> stockList = (List<Stock>) repository.findAll();
        int n = stockList.size();
        Stock firstBook = null;
        if (n > 0) firstBook = stockList.get(0);
        if (firstBook != null) repository.save(firstBook);
        assert ((List<Stock>) repository.findAll()).size() == n;
        assert ((List<Stock>) repository.findAll()).get(0).equals(firstBook);
    }
}
