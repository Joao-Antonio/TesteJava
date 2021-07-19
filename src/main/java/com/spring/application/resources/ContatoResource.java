package com.spring.application.resources;

import com.spring.application.domain.Contato;
import com.spring.application.repository.ContatoRepository;
import com.spring.application.transfer.ContatoTransfer;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoResource {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/contato")
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    @GetMapping(value = "/contato/{id}")
    public ResponseEntity<Contato> procurarPorId(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        return ResponseEntity.ok().body(contato);
    }

    @PostMapping("/contato")
    public ContatoTransfer insert(@RequestBody ContatoTransfer novoContato) {
        Contato contato = contatoRepository.findByNomeContato(novoContato.getNomeContato());
        if (contato != null) {
            throw new ServiceException("Email já existe");
        }

        Contato obj  = new Contato();
        obj.setNomeContato(novoContato.getNomeContato());
        obj.setTelefone(novoContato.getTelefone());
        obj.setEmail(novoContato.getEmail());

        obj = contatoRepository.save(obj);

        return new ContatoTransfer(obj);
    }
}
