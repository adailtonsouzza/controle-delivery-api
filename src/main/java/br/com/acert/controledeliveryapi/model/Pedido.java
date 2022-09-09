package br.com.acert.controledeliveryapi.model;

import br.com.acert.controledeliveryapi.model.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.model.enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido")
public class Pedido  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private  Cliente cliente;
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();


    public Pedido() {
    }

    public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Cliente cliente, List<Produto> produtos, TipoPagamento tipoPagamento) {
        this.id = id;
        this.momento = momento;
        this.pedidoStatus = pedidoStatus;
        this.cliente = cliente;
        this.produtos = produtos;
        this.tipoPagamento = tipoPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public Cliente getCliente() {
        return cliente;
    }



    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

   /* public Double getTotal(){
        double soma = 0;
        for (ItensPedido x : itens){
            soma +=  x.getTotalPreco();
        }
        return soma;
    } */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}