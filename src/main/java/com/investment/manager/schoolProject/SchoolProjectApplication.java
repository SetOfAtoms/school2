package com.investment.manager.schoolProject;

import com.investment.manager.schoolProject.controllers.MainController;
import com.investment.manager.schoolProject.models.Portfolio;
import com.investment.manager.schoolProject.models.Stock;
import com.investment.manager.schoolProject.repositories.AssetsRepository;
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
	CommandLineRunner commandLineRunner(AssetsRepository repository){
		return args -> {
			Stock stock = new Stock(223.2, "AAPL");
			repository.save(stock);
		};
	}

}
