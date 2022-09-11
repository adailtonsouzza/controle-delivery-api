package br.com.acert.controledeliveryapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb_entrega")
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "nome")
    @Schema(example = "xxx", defaultValue = "nome")
    @Column( name = "destinatario_nome")
    @NotBlank
    private String nome;
    @JsonProperty(value = "logradouro")
    @Schema(example = "xxx", defaultValue = "logradouro")
    @Column( name = "destinatario_logradouro")
    @NotBlank
    private String  logradouro;
    @JsonProperty(value = "numero")
    @Schema(example = "xxx", defaultValue = "numero")
    @Column( name = "destinatario_numero")
    @NotBlank
    private String numero;
    @JsonProperty(value = "complemento")
    @Schema(example = "xxx", defaultValue = "complemento")
    @Column( name = "destinatario_complemento")
    private String complemento;
    @JsonProperty(value = "bairro")
    @Schema(example = "xxx", defaultValue = "bairro")
    @Column( name = "destinatario_bairro")
    @NotBlank
    private String  bairro;


    @JsonIgnore
    @OneToMany(mappedBy = "entrega")
    private List<Pedido> pedidos = new ArrayList<>();


    public Entrega(){

    }

    public Entrega(Long id, String nome, String logradouro, String numero, String complemento, String bairro) {
        this.id = id;
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
