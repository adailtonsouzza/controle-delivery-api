package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.entities.Cliente;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }


    public Cliente findById(Long id){
       Optional<Cliente> obj =  clienteRepository.findById(id);
       return obj.get();
    }
}
