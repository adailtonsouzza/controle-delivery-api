package br.com.acert.controledeliveryapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_entrega")
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enderecoCompleto;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Pedido pedido;

    public Entrega(){

    }

    public Entrega(Long id, String enderecoCompleto, Pedido pedido) {
        this.id = id;
        this.enderecoCompleto = enderecoCompleto;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrega entrega = (Entrega) o;
        return Objects.equals(id, entrega.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
