package com.investment.manager.schoolProject;

import com.investment.manager.schoolProject.controllers.MainController;
import com.investment.manager.schoolProject.models.Bond;
import com.investment.manager.schoolProject.models.Portfolio;
import com.investment.manager.schoolProject.models.Stock;
import com.investment.manager.schoolProject.repositories.AssetsRepository;
import com.investment.manager.schoolProject.repositories.BondRepository;
import com.investment.manager.schoolProject.repositories.UserRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SchoolProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AssetsRepository repository, BondRepository bondRepository){
		return args -> {
			Stock stock = new Stock(250, "AAPL");
			Stock stock2 = new Stock(3000, "TSLA");
			Stock stock3 = new Stock(17, "SNAP");
			repository.save(stock);
			repository.save(stock2);
			repository.save(stock3);
			Bond bond = new Bond(1000, 1090.4, "Bank of Finland");
			bondRepository.save(bond);
		};
	}

}
