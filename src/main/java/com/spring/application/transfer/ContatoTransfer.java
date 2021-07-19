package com.spring.application.transfer;

import com.spring.application.domain.Contato;

public class ContatoTransfer {

    private Long idContato;
    private String nomeContato;
    private String telefone;
    private String email;

    public ContatoTransfer(){
    }

    public ContatoTransfer(Long idContato, String nomeContato, String telefone, String email) {
        super();
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.email = email;
    }

    public ContatoTransfer(Contato domain) {
        super();
        this.idContato = domain.getIdContato();
        this.nomeContato = domain.getNomeContato();
        this.telefone = domain.getTelefone();
        this.email = domain.getEmail();
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
}
