package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.ClienteDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
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

    public Cliente cadastrar(ClienteDTO clienteDTO){
      Cliente cliente = new Cliente();
      cliente.setNome(clienteDTO.getNome());
      cliente.setTelefone(clienteDTO.getTelefone());
      cliente.setSenha(encoder.encode(clienteDTO.getSenha()));
      return clienteRepository.save(cliente);

    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente alterar(Long id, ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.getOne(id);
        alterarDados(cliente, clienteDTO);
        return clienteRepository.save(cliente);
    }

    private void alterarDados(Cliente cliente, ClienteDTO clienteDTO) {
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setSenha(encoder.encode(cliente.getSenha()));

    }
}
