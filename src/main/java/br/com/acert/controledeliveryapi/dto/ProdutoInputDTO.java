package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoInputDTO {

    private Long clienteId;

    private List<Produto> produtos = new ArrayList<>();

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
