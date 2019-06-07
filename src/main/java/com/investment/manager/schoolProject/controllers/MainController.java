package com.investment.manager.schoolProject.controllers;

import com.investment.manager.schoolProject.repositories.AssetsRepository;
import com.investment.manager.schoolProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value="/main")
    public String main() {
        return "main";
    }

    @Autowired
    private AssetsRepository assetsRepository;
    @Autowired
    private UserRepository userRepository;
}
