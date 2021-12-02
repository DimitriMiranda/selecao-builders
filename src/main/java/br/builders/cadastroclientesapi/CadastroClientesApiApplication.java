package br.builders.cadastroclientesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CadastroClientesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroClientesApiApplication.class, args);
	}

}
