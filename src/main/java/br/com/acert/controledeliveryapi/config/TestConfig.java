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

        Categoria cat1 = new Categoria(null, "Pastel");
        Categoria cat2 = new Categoria(null, "Suco");
        Categoria cat3 = new Categoria(null, "Refrigerante");

        Produto pr1 = new Produto(null, "Frango/Catupiry", "Pastel de frango com catupiry", 6.5 );
        Produto pr2 = new Produto(null, "Misto", "Pastel com queijo e presunto", 7.0);
        Produto pr3 = new Produto(null, "Suco Laranja", "Suco de laranja com gelo e limão", 5.0);
        Produto pr4 = new Produto(null, "Coca-Coca", "Coca-Coca com limão e gelo", 5.0);
        Produto pr5 = new Produto(null, "Guarana", "muito bom", 3.99);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

        pr1.getCategorias().add(cat1);
        pr2.getCategorias().add(cat1);
        pr2.getCategorias().add(cat1);
        pr3.getCategorias().add(cat2);
        pr4.getCategorias().add(cat3);
        pr5.getCategorias().add(cat3);

        produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));


        Cliente c1 = new Cliente(null, "Adailton Souza", "75999193244", "12345");
        Cliente c2 = new Cliente(null, "Flaviane Dantas", "75999994098", "12345");


        Pedido p1 = new Pedido(null, Instant.parse("2022-09-07T19:53:07Z"), PedidoStatus.PAGO, c1);
        Pedido p2 = new Pedido(null, Instant.parse("2022-09-07T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c2);
        Pedido p3 = new Pedido(null, Instant.parse("2022-09-07T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, c1);
        Pedido p4 = new Pedido(null, Instant.parse("2022-09-07T21:49:07Z"), PedidoStatus.ENVIADO, c2);

        clienteRepository.saveAll(Arrays.asList(c1, c2));
        pedidoRepository.saveAll(Arrays.asList(p1,p2,p3, p4));

        ItemPedido oi1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
        ItemPedido oi2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
        ItemPedido oi3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
        ItemPedido oi4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());
        ItemPedido oi5 = new ItemPedido(p4, pr1, 1, pr1.getPreco());

        itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));

        Pagamento pagamento = new Pagamento(null, Instant.parse("2022-09-07T21:53:07Z"), p4);
        Entrega entrega = new Entrega(null, "Rua luis santana lima, centro, numero 45", p4);
        p4.setEntraga(entrega);
        p4.setPagamento(pagamento);

        pedidoRepository.save(p4);
    }
}
