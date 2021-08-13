package com.spring.application.resources;

import com.spring.application.domain.Contato;
import com.spring.application.domain.dto.ContatoDTO;
import com.spring.application.repository.ContatoRepository;
import com.spring.application.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;
    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping(value = "/contato/{id}")
    public ResponseEntity<Contato> adicionarContato(@PathVariable Long id, @RequestBody Contato contato){
        Contato novoContato = new Contato();

        novoContato = contatoService.adicionarContato(id, contato);

        return new ResponseEntity<>(novoContato, HttpStatus.OK);
    }

    @PutMapping(value = "/contato/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody ContatoDTO novoContato){
        Contato contato  = contatoService.buscarId(id);
        contato.setNomeContato(novoContato.getNomeContato());
        contato.setEmail(novoContato.getEmail());
        contato.setTelefone(novoContato.getTelefone());

        contatoService.modificar(contato);
        return new ResponseEntity<>(contato, HttpStatus.OK);
    }

    @DeleteMapping(value = "/contato/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
