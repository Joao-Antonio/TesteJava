package com.spring.application.repository;

import com.spring.application.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
    Pessoa findByNome(String nome);
}
