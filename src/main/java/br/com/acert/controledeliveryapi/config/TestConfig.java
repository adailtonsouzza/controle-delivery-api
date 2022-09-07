package br.com.acert.controledeliveryapi.config;

import br.com.acert.controledeliveryapi.entities.Cliente;
import br.com.acert.controledeliveryapi.entities.Pedido;
import br.com.acert.controledeliveryapi.entities.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import br.com.acert.controledeliveryapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente(null, "Adailton Souza", "75999193244", "12345");
        Cliente c2 = new Cliente(null, "Flaviane Dantas", "75999994098", "12345");
        Cliente c3 = new Cliente(null, "Lívia Souza", "75999994098", "12345");



        Pedido p1 = new Pedido(null, Instant.parse("2022-09-07T19:53:07Z"), PedidoStatus.PAGO, c1);
        Pedido p2 = new Pedido(null, Instant.parse("2022-09-07T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c2);
        Pedido p3 = new Pedido(null, Instant.parse("2022-09-07T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c1);

        clienteRepository.saveAll(Arrays.asList(c1, c2));
        pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
