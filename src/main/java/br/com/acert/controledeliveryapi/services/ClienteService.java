package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.ClienteDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.form.ClienteForm;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;


    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }


    public Cliente buscarPorId(Long id){
       Optional<Cliente> obj =  clienteRepository.findById(id);
       return obj.get();
    }

    public Cliente cadastrar(ClienteForm clienteDTO){
      Cliente cliente = new Cliente();
      cliente.setNome(clienteDTO.getNome());
      cliente.setTelefone(clienteDTO.getTelefone());
      cliente.setSenha(encoder.encode(clienteDTO.getSenha()));
      return clienteRepository.save(cliente);

    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente alterar(Long id, ClienteForm clienteForm){
       Optional<Cliente>  cliente = clienteRepository.findById(id);
       if (cliente.isPresent()){
           alterarDados(cliente.get(), clienteForm);
           return clienteRepository.save(cliente.get());
       }
        throw new RuntimeException("Entrega não encontrada!");
    }

    private void alterarDados(Cliente cliente, ClienteForm clienteForm) {
        cliente.setNome(clienteForm.getNome());
        cliente.setTelefone(clienteForm.getTelefone());
        cliente.setSenha(encoder.encode(cliente.getSenha()));
    }
}
