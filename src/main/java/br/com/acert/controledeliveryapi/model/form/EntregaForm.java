package br.com.acert.controledeliveryapi.model.form;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class EntregaForm {

    @Column( name = "destinatario_nome")
    @NotBlank
    private String nome;

    @Column( name = "destinatario_logradouro")
    @NotBlank
    private String  logradouro;

    @Column( name = "destinatario_numero")
    @NotBlank
    private String numero;

    @Column( name = "destinatario_complemento")
    private String complemento;

    @Column( name = "destinatario_bairro")
    @NotBlank
    private String  bairro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
