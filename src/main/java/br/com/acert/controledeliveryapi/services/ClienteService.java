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

    public Cliente inserir(Cliente obj){
        return clienteRepository.save(obj);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente alterar(Long id, Cliente obj){
        Cliente entity = clienteRepository.getOne(id);
        alterarDados(entity, obj);
        return clienteRepository.save(entity);
    }

    private void alterarDados(Cliente entity, Cliente obj) {
        entity.setNome(obj.getNome());
        entity.setTelefone(obj.getTelefone());

    }
}
