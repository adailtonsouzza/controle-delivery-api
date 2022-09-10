package br.com.acert.controledeliveryapi.dto;

import br.com.acert.controledeliveryapi.model.Pedido;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Service
public class EntregaDTO {

    private Long id;

    private Long pedidoId;

    @Column( name = "destinatario_nome")
    @NotBlank
    private String nome;
    @Column( name = "destinatario_logradouro")
    @NotBlank
    private String  logradouro;
    @Column( name = "destinatario_numero")
    @NotBlank
    private String numero;
    @Column( name = "destinatario_complemento")
    private String complemento;
    @Column( name = "destinatario_bairro")
    @NotBlank
    private String  bairro;

    public EntregaDTO(){
    }

    public EntregaDTO(Long id, Long pedidoId, String nome, String logradouro, String numero, String complemento, String bairro) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
