package br.com.acert.controledeliveryapi.config;

import br.com.acert.controledeliveryapi.entities.*;
import br.com.acert.controledeliveryapi.entities.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.repositories.*;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5 );
        Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0);
        Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0);
        Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0);
        Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        pr1.getCategorias().add(cat2);
        pr2.getCategorias().add(cat1);
        pr2.getCategorias().add(cat3);
        pr3.getCategorias().add(cat3);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        Cliente c1 = new Cliente(null, "Adailton Souza", "75999193244", "12345");
        Cliente c2 = new Cliente(null, "Flaviane Dantas", "75999994098", "12345");
        Cliente c3 = new Cliente(null, "Lívia Souza", "75999994098", "12345");



        Pedido p1 = new Pedido(null, Instant.parse("2022-09-07T19:53:07Z"), PedidoStatus.PAGO, c1);
        Pedido p2 = new Pedido(null, Instant.parse("2022-09-07T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c2);
        Pedido p3 = new Pedido(null, Instant.parse("2022-09-07T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c1);

        clienteRepository.saveAll(Arrays.asList(c1, c2));
        pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));

        ItemPedido oi1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
        ItemPedido oi2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
        ItemPedido oi3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
        ItemPedido oi4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());

        itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
