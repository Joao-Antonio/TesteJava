package com.spring.application.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 10)
    private String cpf;
    @Column(nullable = false, length = 10)
    private String dataNacimento;

//    private ArrayList<Contato> contatos;

    public Pessoa() {

    }

    public Pessoa(Integer id, String nome, String cpf, String dataNacimento) {
        super();
//        contatos = new ArrayList<Contato>();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNacimento = dataNacimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public String getDataNacimento() {
        return dataNacimento;
    }


    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
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
