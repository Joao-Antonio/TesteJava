package com.spring.application.service;

import com.spring.application.domain.Pessoa;
import com.spring.application.repository.PessoaRepository;
import com.spring.application.transfer.PessoaTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return pessoa;
    }

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setId(null);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa modificar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public void deletar(Long id) {
        buscarId(id);
    }

}
