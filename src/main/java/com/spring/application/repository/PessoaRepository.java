package com.spring.application.repository;

import com.spring.application.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Aqui fazemos o padrão Spring data repository, na qual adicionamos a classe na qual é feita a persistencia
@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

}
