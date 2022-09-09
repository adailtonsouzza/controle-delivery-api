package br.com.acert.controledeliveryapi.config;

import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.repositories.ClienteRepository;
import br.com.acert.controledeliveryapi.repositories.PedidoRepository;
import br.com.acert.controledeliveryapi.repositories.ProdutoRepository;
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

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;




    @Override
    public void run(String... args) throws Exception {


/*
        Produto produto1 = new Produto(null, "Frango/Catupiry", "Pastel de frango com catupiry", 6.5 );
        Produto produto2 = new Produto(null, "Misto", "Pastel com queijo e presunto", 7.0);
        Produto produto3 = new Produto(null, "Suco Laranja", "Suco de laranja com gelo e limão", 5.0);
        Produto produto4 = new Produto(null, "Coca-Coca", "Coca-Coca com limão e gelo", 5.0);
        Produto produto5 = new Produto(null, "Guarana", "muito bom", 3.99);


        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));



        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));*/


        Cliente cliente1 = new Cliente(null, "Adailton Souza", "75999193244", "12345");
        Cliente cliente2 = new Cliente(null, "Flaviane Dantas", "75999994098", "12345");

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

    /*
        Pedido pedido1 = new Pedido(null, Instant.parse("2022-09-07T19:53:07Z"), PedidoStatus.ENVIADO, cliente1);
        Pedido pedido2 = new Pedido(null, Instant.parse("2022-09-07T03:42:10Z"), PedidoStatus.ANDAMENTO, cliente2);
        Pedido pedido3 = new Pedido(null, Instant.parse("2022-09-07T15:21:22Z"), PedidoStatus.ANDAMENTO, cliente1);
        Pedido pedido4 = new Pedido(null, Instant.parse("2022-09-07T21:49:07Z"), PedidoStatus.ENVIADO, cliente2);


        pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3, pedido4));



        Pagamento pagamento = new Pagamento(null, Instant.parse("2022-09-07T21:53:07Z"),pedido4);


        pedidoRepository.save(pedido4); */
    }
}
