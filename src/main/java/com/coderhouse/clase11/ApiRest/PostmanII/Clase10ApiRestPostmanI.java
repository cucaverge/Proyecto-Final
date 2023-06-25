package com.coderhouse.clase11.ApiRest.PostmanII;

import com.coderhouse.clase11.ApiRest.PostmanII.repository.ClientRepository;
import com.coderhouse.clase11.ApiRest.PostmanII.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase10ApiRestPostmanI implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Clase10ApiRestPostmanI.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");
	}
}