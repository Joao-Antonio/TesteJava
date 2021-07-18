package com.spring.application.resources;


import com.spring.application.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.application.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> todasPessoas(){
        List<Pessoa> list = pessoaRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> procurarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
        return ResponseEntity.ok().body(pessoa);
    }

//    @PostMapping("/pessoa/salvar")
//    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
//        Pessoa pessoaAdicionar = new Pessoa();
//        pessoaAdicionar.setId(null);
//        pessoaAdicionar.setNome(pessoa.getNome());
//        pessoaAdicionar.setCpf(pessoa.getCpf());
//        pessoaAdicionar.setDataNacimento(pessoa.getDataNacimento());
//
//        return new ResponseEntity<Pessoa>(pessoaAdicionar, HttpStatus.OK);
//    }
}
