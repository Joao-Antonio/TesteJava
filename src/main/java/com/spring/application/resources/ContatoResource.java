package com.spring.application.resources;

import com.spring.application.domain.Contato;
import com.spring.application.domain.Pessoa;
import com.spring.application.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Contato")
public class ContatoResource {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<Contato>> todasPessoas(){
        List<Contato> list = contatoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Contato> procurarPorId(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        return ResponseEntity.ok().body(contato);
    }
}
