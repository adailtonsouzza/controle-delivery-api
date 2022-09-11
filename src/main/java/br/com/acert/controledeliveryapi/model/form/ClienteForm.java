package br.com.acert.controledeliveryapi.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {
    @NotNull
    private String nome;

    private String telefone;

    @NotBlank
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
