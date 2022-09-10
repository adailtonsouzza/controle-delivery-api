package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Pedido;

import java.util.List;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    private List<Pedido> pedidos;

    public ProdutoDTO(){

    }

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.pedidos = pedidos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedido) {
        this.pedidos = pedido;
    }
}
