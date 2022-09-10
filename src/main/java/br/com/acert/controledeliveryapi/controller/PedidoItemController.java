package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.model.pk.PedidoItemPK;
import br.com.acert.controledeliveryapi.services.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidoItens")
public class PedidoItemController {

    @Autowired
    private PedidoItemService service;

    @GetMapping
    public ResponseEntity<List<PedidoItem>> buscarTodosItens(){
        List<PedidoItem> list = service.buscarTodosItens();
        return ResponseEntity.ok().body(list);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public PedidoItem adicionandoItens(@RequestBody PedidoItemDTO pedidoItemDTO){
        PedidoItem pedidoItem = service.adicionarItem(pedidoItemDTO);
        return  pedidoItem;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoItem> alterarItem(@PathVariable PedidoItemPK id, @RequestBody PedidoItemDTO pedidoItemDTO){
        PedidoItem pedidoItem = service.alterarItem(id, pedidoItemDTO);
        return ResponseEntity.ok().body(pedidoItem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable PedidoItemPK id){
        service.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}
