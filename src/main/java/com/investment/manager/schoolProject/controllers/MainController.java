package com.investment.manager.schoolProject.controllers;

import com.investment.manager.schoolProject.repositories.AssetsRepository;
import com.investment.manager.schoolProject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
    public AssetsRepository repository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    Logger logger = LoggerFactory.getLogger(MainController.class);


    @GetMapping(value="/main")
    public String main(Model model) {
        model.addAttribute("stocks", repository.findAll());
        return "main";
    }

}
