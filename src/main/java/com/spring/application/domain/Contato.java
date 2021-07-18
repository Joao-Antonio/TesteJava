package com.spring.application.domain;

public class Contato extends Pessoa {

    private Integer idContato;
    private String nomeContato;
    private String telefone;
    private String email;

    public Contato() {

    }

    public Contato(Integer idContato, String nomeContato, String telefone, String email) {
        super();
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
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

    @Override
    public String toString() {
        return "\n Contato [idContato=" + idContato + ", nomeContato=" + nomeContato + ", telefone=" + telefone
                + ", email=" + email + "";
    }

}
