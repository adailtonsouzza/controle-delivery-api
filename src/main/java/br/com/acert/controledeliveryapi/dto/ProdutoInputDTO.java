package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.model.enums.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class ProdutoInputDTO {

    private Long clienteId;

    private List<Produto> produtos = new ArrayList<>();


    private TipoPagamento tipoPagamento;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
