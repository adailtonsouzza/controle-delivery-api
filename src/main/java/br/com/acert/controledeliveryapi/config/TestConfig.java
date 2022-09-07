package br.com.acert.controledeliveryapi.config;

import br.com.acert.controledeliveryapi.entities.Cliente;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente(null, "Adailton Souza", "75999193244", "12345");
        Cliente c2 = new Cliente(null, "Flaviane Dantas", "75999994098", "12345");

        clienteRepository.saveAll(Arrays.asList(c1, c2));
    }
}
