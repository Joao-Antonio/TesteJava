package com.spring.application.resources;


import com.spring.application.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.application.repository.PessoaRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public List<Pessoa> listaPessoas(){
        return pessoaRepository.findAll();
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
