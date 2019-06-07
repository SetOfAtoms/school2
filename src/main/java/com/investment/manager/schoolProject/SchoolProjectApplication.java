package com.investment.manager.schoolProject;

import com.investment.manager.schoolProject.models.Portfolio;
import com.investment.manager.schoolProject.repositories.AssetsRepository;
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
			List<Portfolio> stocks = new ArrayList<>();
			Portfolio portfolio1 = new Portfolio();
			Portfolio portfolio2 = new Portfolio();
			Portfolio portfolio3 = new Portfolio();
			repository.save(portfolio1);
			repository.save(portfolio2);
			repository.save(portfolio3);
		};
	}

}
