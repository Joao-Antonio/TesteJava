package com.spring.application.resources;


import com.spring.application.domain.Pessoa;
import com.spring.application.repository.PessoaRepository;
import com.spring.application.transfer.PessoaTransfer;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();

    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> procurarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/pessoa")
    public PessoaTransfer inserirPessoa(@RequestBody PessoaTransfer novaPessoa) {
        Pessoa pessoa = pessoaRepository.findByNome(novaPessoa.getNome());
        if (pessoa != null) {
            throw new ServiceException("Email já existe");
        }

        Pessoa obj = new Pessoa();
        obj.setNome(novaPessoa.getNome());
        obj.setCpf(novaPessoa.getCpf());
        obj.setDataNacimento(novaPessoa.getDataNacimento());

        obj = pessoaRepository.save(obj);

        return new PessoaTransfer(obj);
    }

    @PutMapping (value = "/pessoa/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody PessoaTransfer novaPessoa) {
        Pessoa pessoa = pessoaRepository.findById(id).get();

        pessoa.setNome(novaPessoa.getNome());
        pessoa.setCpf(novaPessoa.getCpf());
        pessoa.setDataNacimento(novaPessoa.getDataNacimento());

        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping (value = "/pessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
        return ResponseEntity.noContent().build();
    }

}
