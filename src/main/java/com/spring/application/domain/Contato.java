package com.spring.application.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContato;
    @Column(nullable = false, length = 50)
    private String nomeContato;
    @Column(nullable = false, length = 10)
    private String telefone;
    @Column(nullable = false, length = 20)
    private String email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Contato(){

    }

    public void Contato(){

    }

    public Contato(Long idContato, String nomeContato, String telefone, String email, Pessoa pessoa) {
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
        this.pessoa = pessoa;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return idContato.equals(contato.idContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContato);
    }
}
