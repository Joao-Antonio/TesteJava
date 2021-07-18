package com.spring.application.resources;


import com.spring.application.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.application.repository.PessoaRepository;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(method=RequestMethod.GET)
    public String imprime(){
        return "Online";
    }

//    @GetMapping("/pessoa")
//    public List<Pessoa> listaPessoas(){
//        return pessoaRepository.findAll();
//    }
//
//    @PostMapping("/pessoa/salvar")
//    public Pessoa salvar(@RequestBody Pessoa pessoa){
//        return pessoaRepository.save(pessoa);
//    }
}
