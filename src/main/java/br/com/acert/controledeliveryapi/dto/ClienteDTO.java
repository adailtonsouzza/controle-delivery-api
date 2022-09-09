package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String senha;


    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.senha = cliente.getSenha();

    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return  clientes.stream().map(Cliente -> {
            ClienteDTO vo2 = new ClienteDTO(Cliente);
            return vo2;
        }).collect(Collectors.toList());
    }
}
