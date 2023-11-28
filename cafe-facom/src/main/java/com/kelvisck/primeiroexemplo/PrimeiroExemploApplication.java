package com.kelvisck.primeiroexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;


// documentacao em http://localhost:8085/swagger-ui/index.html 


@SpringBootApplication

@ComponentScan("com.kelvisck.primeiroexemplo")
public class PrimeiroExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroExemploApplication.class, args);
	}

}
