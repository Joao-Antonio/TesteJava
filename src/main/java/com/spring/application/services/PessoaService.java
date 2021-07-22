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

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();

        return pessoa;
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

    public Pessoa modificar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public void deletar(Long id) {
        buscarId(id);
    }

}
