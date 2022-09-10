package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.EntregaDTO;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.services.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
    @Autowired
    private EntregaService service;

    @GetMapping
    public ResponseEntity<List<Entrega>> buscarTodasEntregas(){
        List<Entrega> list = service.buscarTodasEntregas();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Entrega> buscarEntregaPorId(@PathVariable Long id){
        Entrega entrega = service.buscarPorId(id);
        return  ResponseEntity.ok().body(entrega);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Entrega cadastroEntrega(@RequestBody EntregaDTO entregaDTO){
        Entrega entrega = service.cadastrarEndercoDaEntrega(entregaDTO);
        return entrega;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Entrega> alterarEndereco(@PathVariable Long id, @RequestBody EntregaDTO entregaDTO){
        Entrega entrega = service.alterarEndereco(id, entregaDTO);
        return  ResponseEntity.ok().body(entrega);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletarEntrega(id);
        return ResponseEntity.noContent().build();
    }


}
