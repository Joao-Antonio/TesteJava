package com.spring.application.transfer;

import com.spring.application.domain.Pessoa;

public class PessoaTransfer {

    private Long id;
    private String nome;
    private String cpf;
    private String dataNacimento;

    public PessoaTransfer(){
    }

    public PessoaTransfer(Long id, String nome, String cpf, String dataNacimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNacimento = dataNacimento;
    }

    public PessoaTransfer(Pessoa domain) {
        super();
        this.id = domain.getId();
        this.nome = domain.getNome();
        this.cpf = domain.getCpf();
        this.dataNacimento = domain.getDataNacimento();
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

    public String getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(String dataNacimento) {
        this.dataNacimento = dataNacimento;
    }
}
