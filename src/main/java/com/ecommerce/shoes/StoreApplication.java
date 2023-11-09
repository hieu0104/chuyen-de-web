package com.ecommerce.shoes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.ecommerce.shoes.service.UserService;
@SpringBootApplication
@ComponentScan(basePackages = {"com.ecommerce.shoes.*"})

@EnableCaching

public class StoreApplication implements CommandLineRunner {	

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}



	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		userService.createUser("admin", "admin", "admin@gmail.com", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
	}

}
