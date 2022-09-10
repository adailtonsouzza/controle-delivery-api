package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.repositories.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemService {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired PedidoService pedidoService;

    public PedidoItem adicionarItemNoPedido(PedidoItemDTO pedidoItemDTO){
        Pedido pedido = pedidoService.findById((pedidoItemDTO.getPedidoId()));
        Produto produto = produtoService.findById(pedidoItemDTO.getProdutoId());

        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setPedido(pedido);
        pedidoItem.setProduto(produto);
        pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
        pedidoItem.setPreco(produto.getPreco());
        return pedidoItemRepository.save(pedidoItem);

    }

}
