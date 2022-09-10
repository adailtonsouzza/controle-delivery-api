package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import br.com.acert.controledeliveryapi.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByNome(nome);
        if(cliente.isPresent()){
            return new UserSS(cliente.get().getId(), cliente.get().getNome(), cliente.get().getSenha());
        }
        throw  new UsernameNotFoundException(nome);
    }

}
