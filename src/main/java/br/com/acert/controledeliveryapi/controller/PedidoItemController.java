package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.services.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidoItens")
public class PedidoItemController {

    @Autowired
    private PedidoItemService service;


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public PedidoItem adicionandoItens(@RequestBody PedidoItemDTO pedidoItemDTO){
        PedidoItem pedidoItem = service.adicionarItemNoPedido(pedidoItemDTO);
        return  pedidoItem;
    }
}
