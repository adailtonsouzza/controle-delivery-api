package br.com.acert.controledeliveryapi.resources;

import br.com.acert.controledeliveryapi.entities.Cliente;
import br.com.acert.controledeliveryapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
