package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.Produto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    public ProdutoDTO(){

    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();

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

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(produto -> {
            ProdutoDTO dto = new ProdutoDTO(produto);
            return dto;
        }).collect(Collectors.toList());
    }


}
