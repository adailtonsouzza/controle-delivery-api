package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.EntregaDTO;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.model.form.EntregaForm;
import br.com.acert.controledeliveryapi.services.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Entrega Controller")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
    @Autowired
    private EntregaService service;

    @Operation(summary = "Retorna todas as entregas")
    @GetMapping
    public ResponseEntity<List<Entrega>> buscarTodasEntregas(){
        List<Entrega> list = service.buscarTodasEntregas();
        return  ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Retorna Entrega por ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Entrega> buscarEntregaPorId(@PathVariable Long id){
        Entrega entrega = service.buscarPorId(id);
        return  ResponseEntity.ok().body(entrega);
    }

    @Operation(summary = "Faz cadastro de entrega (Endereço)")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Entrega cadastroEntrega(@RequestBody EntregaForm entregaForm){
        Entrega entrega = service.cadastrarEndercoDaEntrega(entregaForm);
        return entrega;
    }

    @Operation(summary = "Alterar dados da entrega")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Entrega> alterarEndereco(@PathVariable Long id, @RequestBody EntregaForm entregaForm){
        Entrega entrega = service.alterarEndereco(id, entregaForm);
        return  ResponseEntity.ok().body(entrega);
    }

    @Operation(summary = "Deleta entrega por ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletarEntrega(id);
        return ResponseEntity.noContent().build();
    }


}
