package com.spring.application;

import com.spring.application.domain.Pessoa;
import com.spring.application.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "Gabi", "874654654", "22/22/22");
		Pessoa p2 = new Pessoa(null, "Maria", "998995566", "23/22/33");

		pessoaRepository.saveAll(Arrays.asList(p1, p2));

	}
}
