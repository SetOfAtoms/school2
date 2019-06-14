package com.investment.manager.schoolProject.controllers;

import com.investment.manager.schoolProject.models.Bond;
import com.investment.manager.schoolProject.models.Stock;
import com.investment.manager.schoolProject.repositories.AssetsRepository;
import com.investment.manager.schoolProject.repositories.BondRepository;
import com.investment.manager.schoolProject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController implements ErrorController {

    @Autowired
    public AssetsRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BondRepository bondRepository;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    Logger logger = LoggerFactory.getLogger(MainController.class);


    @GetMapping(value="/main")
    public String main(Model model) {
        // incase we have no stocks or bonds
        try{
            model.addAttribute("stocks", repository.findAll());
            model.addAttribute("stock", repository.findAll().iterator().next());

        }catch (Exception ignored){}
        model.addAttribute("stocksValue", getStockValue());
        try {
            model.addAttribute("bonds", bondRepository.findAll());
        }catch (Exception ignored){}
        model.addAttribute("bondsValue", getBondValue());

        try {
            model.addAttribute("balance", getBondValue()+getStockValue());
        }catch (Exception ignored){}

        return "main";
    }


    // stock
    @RequestMapping(value = "/addstock")
    public String addstock(Model model){
        model.addAttribute("stock", new Stock());
        return "addstock";
    }
    @RequestMapping(value = "/savestock", method = RequestMethod.POST)
    public String savestock(Stock stock){
        if(stock.price<1 || stock.ticker.length() <1 || stock.ticker.length()>5){
            return "redirect:add";
        }
        Stock newStock = new Stock(stock.price, stock.ticker);
        repository.save(newStock);
        return "redirect:main";
    }
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public @ResponseBody
    List<Stock> stocks(){
        return (List<Stock>) repository.findAll();
    }
    @RequestMapping(value = "/stocks/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Stock> findStockById(@PathVariable("id")Long Id){
        return repository.findById(Id);
    }

    @RequestMapping(value = "/delete/stock/{id}", method = RequestMethod.GET)
    public String deleteStock(@PathVariable("id") Long Id, Model model) {
        repository.deleteById(Id);
        return "redirect:/main";
    }

    @RequestMapping(value = "/history/stock/{id}", method = RequestMethod.GET)
    public String showStockHistory(@PathVariable("id") Long Id, Model model) {
        Stock stock;
        stock = repository.findAllById(Collections.singleton(Id)).iterator().next();
        model.addAttribute("stock", stock);
        model.addAttribute("ticker", stock.ticker);
        return "stockhistory";
    }

    // bond
    @RequestMapping(value = "/addbond")
    public String addbond(Model model){
        model.addAttribute("bond", new Bond());
        return "addbond";
    }
    @RequestMapping(value = "/savebond", method = RequestMethod.POST)
    public String savebond(Bond bond){
        if(bond.initialPrice<100 || bond.issuer.length() <3){
            return "redirect:addbond";
        }
        Bond newBond = new Bond(bond.initialPrice, 0, bond.issuer);
        bondRepository.save(newBond);
        return "redirect:main";
    }
    @RequestMapping(value = "/delete/bond/{id}", method = RequestMethod.GET)
    public String deleteBond(@PathVariable("id") Long Id, Model model) {
        bondRepository.deleteById(Id);
        return "redirect:/main";
    }

    @RequestMapping(value = "/history/bond/{id}", method = RequestMethod.GET)
    public String showBondHistory(@PathVariable("id") Long Id, Model model) {
        Bond bond;
        bond = bondRepository.findAllById(Collections.singleton(Id)).iterator().next();
        model.addAttribute("bond", bond);
        model.addAttribute("bondname", bond.issuer);

        return "bondhistory";
    }
    @RequestMapping(value = "/bonds", method = RequestMethod.GET)
    public @ResponseBody
    List<Bond> bonds(){
        return (List<Bond>) bondRepository.findAll();
    }
    @RequestMapping(value = "/bonds/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Bond> findBondById(@PathVariable("id")Long Id){
        return bondRepository.findById(Id);
    }


    // ERROR and empty page
    @RequestMapping(value="/")
    public String empty(Model model) {
        return main(model);
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    // custom methods
    private long getStockValue() {
        long value = 0;
        try {
        Iterator iterator = repository.findAll().iterator();
        for (int i = 0; i < repository.count(); i++) {
            if(iterator.hasNext()) {
                Stock stock = (Stock) iterator.next();
                value += stock.history[19];
            }
        }
        }catch (Exception e){}

        return value;
    }
    private long getBondValue() {
        long value = 0;
        try {
            Iterator iterator = bondRepository.findAll().iterator();
        for (int i = 0; i < bondRepository.count(); i++) {
            if(iterator.hasNext()) {
                Bond bond = (Bond) iterator.next();
                value += bond.history[19];
            }
        }
        }catch (Exception e){}


        return value;
    }
}
