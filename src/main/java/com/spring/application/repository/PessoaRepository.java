package com.spring.application.repository;

import com.spring.application.domain.Pessoa;
import com.spring.application.transfer.PessoaTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
    Pessoa findByNome(String nome);
}
