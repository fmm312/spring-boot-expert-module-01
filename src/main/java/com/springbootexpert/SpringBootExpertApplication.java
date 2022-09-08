package com.springbootexpert;

import com.springbootexpert.domain.entity.Cliente;
import com.springbootexpert.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootExpertApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando clientes");
			clientes.save(new Cliente("Felipe"));
			clientes.save(new Cliente("Outro cliente"));

			boolean existe = clientes.existByNome("Felipe");
			System.out.println("Existe um cliente com o nome Felipe? " + existe);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExpertApplication.class, args);
	}

}
