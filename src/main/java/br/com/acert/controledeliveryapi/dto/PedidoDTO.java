package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.model.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.model.enums.TipoPagamento;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {


    private Instant momento;

    private String observacao;

    private PedidoStatus pedidoStatus;

    private TipoPagamento tipoPagamento;

    private Long clienteId;


    private Long entregaId;



    public PedidoDTO(){

    }
    public PedidoDTO(Instant momento, String observacao, PedidoStatus pedidoStatus, TipoPagamento tipoPagamento, Long clienteId, Long entregaId) {
        this.momento = momento;
        this.observacao = observacao;
        this.pedidoStatus = pedidoStatus;
        this.tipoPagamento = tipoPagamento;
        this.clienteId = clienteId;
        this.entregaId = entregaId;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }



    public Long getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Long entregaId) {
        this.entregaId = entregaId;
    }
}
