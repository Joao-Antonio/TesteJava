package com.spring.application.repository;

import com.spring.application.domain.Contato;
import com.spring.application.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
    Contato findByNomeContato(String nome);

}
