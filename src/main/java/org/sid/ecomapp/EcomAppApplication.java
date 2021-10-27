package org.sid.ecomapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;

@SpringBootApplication
public class EcomAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){

		return args -> {
			productRepository.save(new Product(null, "Ord HP 564", 8000));
			productRepository.save(new Product(null, "Iprimante LX", 100));
			productRepository.save(new Product(null, "Smart phone samsung", 9900));
			productRepository.findAll().forEach(product -> {
				System.out.printf(product.name);
			});
		};
	}
}
