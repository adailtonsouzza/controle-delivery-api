package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.ClienteDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.form.ClienteForm;
import br.com.acert.controledeliveryapi.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Tag(name = "Cliente Controller")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.buscarTodos();
        return  ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Retorna cliente pelo ID")
    @GetMapping(value =  "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente obj = clienteService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @Operation(summary = "Cadastrar um novo cliente")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente cadastroCliente(@Valid @RequestBody ClienteForm clienteDTO){
       Cliente cliente = clienteService.cadastrar(clienteDTO);
        return cliente;
    }

    @Operation(summary = "Deletar um cliente pelo ID")
    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar um cliente pelo ID")
    @PutMapping(value =  "/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Long id, @RequestBody ClienteForm clienteForm){
        Cliente cliente = clienteService.alterar(id, clienteForm);
        return ResponseEntity.ok().body(cliente);
    }
}
