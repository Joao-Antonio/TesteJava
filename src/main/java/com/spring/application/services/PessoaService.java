package com.spring.application.services;

import com.spring.application.domain.Contato;
import com.spring.application.domain.Pessoa;
import com.spring.application.domain.dto.NovaPessoaDTO;
import com.spring.application.repository.ContatoRepository;
import com.spring.application.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    private ContatoService contatoService;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    @Transactional
    public Pessoa inserir(Pessoa pessoa){
        pessoa.setId(null);

        contatoRepository.saveAll(pessoa.getContato());

        return pessoaRepository.save(pessoa);
    }

    public Pessoa pessoaContatoDTO(NovaPessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa(null, pessoaDTO.getNome(), pessoaDTO.getCpf(), pessoaDTO.getDataNacimento());
        Contato contato = new Contato(null, pessoaDTO.getNomeContato(), pessoaDTO.getTelefone(), pessoaDTO.getEmail(), pessoa);
        pessoa.getContato().add(contato);

        return pessoa;
    }

//    public Pessoa inserirContato(Contato novoContato, Pessoa pessoa) {
//        Contato contato  = new Contato(null, novoContato.getNomeContato(), novoContato.getTelefone(), novoContato.getEmail(), pessoa);
//
//        pessoa.getContato().add(contato);
//        contatoRepository.saveAll(pessoa.getContato());
//        contato = contatoRepository.save(contato);
//
//        return pessoaRepository.save(pessoa);
//    }


    public Pessoa modificar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id) {
        Pessoa pessoaDeletar =  buscarId(id);
        pessoaRepository.delete(pessoaDeletar);
    }
}
