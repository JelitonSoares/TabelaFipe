package br.com.jeli.fipeveiculos;

import br.com.jeli.fipeveiculos.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeveiculosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeveiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*******RUNNING*******");

		Principal.exibirMenu();
	}
}
