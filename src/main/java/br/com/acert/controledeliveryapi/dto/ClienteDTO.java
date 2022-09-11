package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String senha;

    public ClienteDTO(){

    }
    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.senha = cliente.getSenha();

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
