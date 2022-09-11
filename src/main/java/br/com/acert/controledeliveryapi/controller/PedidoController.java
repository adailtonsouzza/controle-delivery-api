package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.form.PedidoForm;
import br.com.acert.controledeliveryapi.model.form.PedidoForm2;
import br.com.acert.controledeliveryapi.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedido Controller")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    @Operation(summary = "Retorna todos os pedidos")
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }
    @Operation(summary = "Retorna os pedidos por ID")
    @GetMapping(value =  "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @Operation(summary = "Cadastra um novo pedido")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Pedido solicitar(@RequestBody PedidoForm pedidoForm){
        Pedido pedido = service.solicitar(pedidoForm);
        return pedido;

    }


    @Operation(summary = "Alterar um pedido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedido> alterarPedido(@PathVariable Long id, @RequestBody PedidoForm2 pedidoForm){
        Pedido pedidoAtualizado = service.alterarPedido(id, pedidoForm);
        return ResponseEntity.ok().body(pedidoAtualizado);
    }

    @Operation(summary = "Deleta um pedido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
