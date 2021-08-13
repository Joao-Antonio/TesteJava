package com.spring.application.domain.dto;

import java.io.Serializable;

public class ContatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeContato;
    private String telefone;
    private String email;

    public ContatoDTO(){

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
}
