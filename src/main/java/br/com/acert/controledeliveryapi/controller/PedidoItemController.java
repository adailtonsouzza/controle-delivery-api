package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.model.form.PedidoItemForm;
import br.com.acert.controledeliveryapi.services.PedidoItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "PedidoItem Controller")
@RestController
@RequestMapping(value = "/pedidoItens")
public class PedidoItemController {

    @Autowired
    private PedidoItemService service;
    @Operation(summary = "Retonar as relações do pedidos e produtos e quantidade e preco")
    @GetMapping
    public ResponseEntity<List<PedidoItem>> buscarTodosItens(){
        List<PedidoItem> list = service.buscarTodosItens();
        return ResponseEntity.ok().body(list);
    }
    @Operation(summary = "Associa um pedido com um produto")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public PedidoItem adicionandoItens(@RequestBody PedidoItemForm pedidoItemForm){
        PedidoItem pedidoItem = service.adicionarItem(pedidoItemForm);
        return  pedidoItem;
    }

}
