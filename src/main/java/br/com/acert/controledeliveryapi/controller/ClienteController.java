package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.ClienteDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.buscarTodos();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente obj = clienteService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente cadastroCliente(@Valid @RequestBody ClienteDTO clienteDTO){
       Cliente cliente = clienteService.cadastrar(clienteDTO);
        return cliente;
    }

    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value =  "/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.alterar(id, clienteDTO);
        return ResponseEntity.ok().body(cliente);
    }
}
