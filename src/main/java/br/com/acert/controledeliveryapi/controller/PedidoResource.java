package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.ProdutoInputDTO;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Pedido solicitar(@RequestBody ProdutoInputDTO produtoInputDTO){
        Pedido pedido = service.solicitar(produtoInputDTO);
        return pedido;

    }
}
