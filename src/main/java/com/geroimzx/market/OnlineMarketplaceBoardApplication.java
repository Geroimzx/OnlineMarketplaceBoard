package com.geroimzx.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.geroimzx.market.Repository")
public class OnlineMarketplaceBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketplaceBoardApplication.class, args);
	}

}
