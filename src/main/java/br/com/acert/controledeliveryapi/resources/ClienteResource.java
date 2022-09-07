package br.com.acert.controledeliveryapi.resources;

import br.com.acert.controledeliveryapi.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @GetMapping
    public ResponseEntity<Cliente> findAll(){
        Cliente c = new Cliente(1L, "Maria", "75999193244", "123");
        return  ResponseEntity.ok().body(c);
    }
}
