package br.com.acert.controledeliveryapi.model;

import br.com.acert.controledeliveryapi.model.pk.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {

    @EmbeddedId
    private PedidoItemPK id = new PedidoItemPK();
    @JsonProperty(value = "quantidade")
    @Schema(example = "1", defaultValue = "quantidade")
    private Integer quantidade;
    @JsonProperty(value = "preco")
    @Schema(example = "1.50", defaultValue = "preco")
    private  Double preco;

    public PedidoItem(){

    }

    public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
         id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }


    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }


    public void setProduto(Produto produto){
        id.setProduto(produto);
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

    public Double getSubTotal(){
        return preco * quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItem that = (PedidoItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

