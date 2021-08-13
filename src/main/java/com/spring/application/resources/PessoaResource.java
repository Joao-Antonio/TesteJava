package com.spring.application.resources;

import com.spring.application.domain.Pessoa;
import com.spring.application.domain.dto.NovaPessoaDTO;
import com.spring.application.repository.PessoaRepository;
import com.spring.application.services.ContatoService;
import com.spring.application.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/pessoa")
    public ResponseEntity<List <Pessoa>> todasPessoas() {
        List<Pessoa> lista = pessoaService.listarTodos();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> procurarPorId(@PathVariable("id") Long id){
		Pessoa pessoa = pessoaService.buscarId(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> inserirPessoa(@Validated @RequestBody NovaPessoaDTO pessoaDTO){
        Pessoa novaPessoa = pessoaService.pessoaContatoDTO(pessoaDTO);
        pessoaService.inserir(novaPessoa);
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
    }

    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa novaPessoa){
        novaPessoa.setId(id);
        pessoaService.modificar(novaPessoa);
        return new ResponseEntity<>(novaPessoa, HttpStatus.OK);
    }

    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
