package br.com.acert.controledeliveryapi.model.form;

import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.model.enums.TipoPagamento;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PedidoForm {

    private String observacao;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    private Long clienteId;

    private Long entregaId;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
