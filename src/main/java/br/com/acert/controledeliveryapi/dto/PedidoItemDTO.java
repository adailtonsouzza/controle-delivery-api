package br.com.acert.controledeliveryapi.dto;

public class PedidoItemDTO {

    private Integer quantidade;
    private  Double preco;

    private Long pedidoId;
    private Long produtoId;

    public PedidoItemDTO(){

    }

    public PedidoItemDTO(Integer quantidade, Double preco, Long pedidoId, Long produtoId) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
