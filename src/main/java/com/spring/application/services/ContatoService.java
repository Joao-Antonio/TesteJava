package com.spring.application.services;

import com.spring.application.domain.Contato;
import com.spring.application.domain.Pessoa;
import com.spring.application.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Contato buscarId(Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        return contato.orElse(null);
    }

    @Transactional
    public Contato inserirContato(Contato contato){
        contato.setIdContato(null);

        return contatoRepository.save(contato);
    }

    public Contato adicionarContato(Long id_pessoa, Contato novoContato) {
        Pessoa pessoa  = pessoaService.buscarId(id_pessoa);

        novoContato = new Contato(null, novoContato.getNomeContato(), novoContato.getTelefone(), novoContato.getEmail(), pessoa);

        pessoa.getContato().add(novoContato);

        return contatoRepository.save(novoContato);
    }

    public Contato modificar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deletar(Long id) {
        Contato contatoDeletar =  buscarId(id);
        contatoRepository.delete(contatoDeletar);
    }
}
