package br.com.acert.controledeliveryapi.config;

import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import br.com.acert.controledeliveryapi.repositories.PedidoRepository;
import br.com.acert.controledeliveryapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {


        Cliente admin = new Cliente(null, "admin", "99999999999", encoder.encode("admin"));


        clienteRepository.save(admin);


    }
}
