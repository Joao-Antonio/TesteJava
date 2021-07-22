package com.spring.application.resources;

import com.spring.application.domain.Pessoa;
import com.spring.application.domain.dto.NovaPessoaDTO;
import com.spring.application.repository.PessoaRepository;
import com.spring.application.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa")
    public ResponseEntity<List <Pessoa>> todasPessoas() {
        List<Pessoa> lista = pessoaService.listarTodos();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> procurarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarId(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Void> inserirPessoa(@RequestBody NovaPessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaService.pessoaContatoDTO(pessoaDTO);
        pessoaService.inserir(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Void>  update(@PathVariable Long id, @RequestBody Pessoa novaPessoa){
        novaPessoa.setId(id);
        pessoaService.modificar(novaPessoa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
