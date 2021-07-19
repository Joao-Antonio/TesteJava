package com.spring.application;

import com.spring.application.domain.Contato;
import com.spring.application.domain.Pessoa;
import com.spring.application.repository.ContatoRepository;
import com.spring.application.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class Application implements CommandLineRunner {

	private PessoaRepository pessoaRepository;
	private ContatoRepository contatoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Pessoa p1 = new Pessoa(null, "Joao", "8744654", "11/11/11");
//		Pessoa p2 = new Pessoa(null, "Gabi", "1744654", "12/11/11");
//
//		Contato c1 = new Contato(null, "Alan", "88447755", "alan@gmail.com");
//		Contato c2 = new Contato(null, "Maria", "99447755", "maria@gmail.com");
//		Contato c3 = new Contato(null, "Chloe", "77447755", "chloe@gmail.com");
//		Contato c4 = new Contato(null, "Neymar", "96447755", "neymar@gmail.com");

//		p1.getContato().addAll(Arrays.asList(c1, c4));
//		p2.getContato().addAll(Arrays.asList(c2, c3));
//
//		pessoaRepository.save(p1);
//		pessoaRepository.save(p2);
//
//		contatoRepository.save(c1);
//		contatoRepository.save(c2);
//		contatoRepository.save(c3);
//		contatoRepository.save(c4);
	}
}
