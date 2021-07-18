package com.spring.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String dataNacimento;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Contato> contato = new ArrayList<>();

    public Pessoa() {

    }

    public Pessoa(Long id, String nome, String cpf, String dataNacimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNacimento = dataNacimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNacimento() { return dataNacimento;
    }
    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public List<Contato> getContato() {
        return contato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(id, other.id);
    }

}
