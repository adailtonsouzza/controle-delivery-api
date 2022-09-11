package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.model.pk.PedidoItemPK;
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

    public List<PedidoItem> buscarTodosItens() {
        return pedidoItemRepository.findAll();
    }

    public PedidoItem adicionarItem(PedidoItemDTO pedidoItemDTO){
        Pedido pedido = pedidoService.findById((pedidoItemDTO.getPedidoId()));
        Produto produto = produtoService.findById(pedidoItemDTO.getProdutoId());

        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setPedido(pedido);
        pedidoItem.setProduto(produto);
        pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
        pedidoItem.setPreco(produto.getPreco());
        return pedidoItemRepository.save(pedidoItem);

    }

   /* public PedidoItem alterarItem(PedidoItemPK id, PedidoItemDTO pedidoItemDTO){
        PedidoItem pedidoItem = pedidoItemRepository.getOne(id);
        alterarDadosItem(pedidoItem, pedidoItemDTO);
        return pedidoItemRepository.save(pedidoItem);
    }

    private void alterarDadosItem(PedidoItem pedidoItem, PedidoItemDTO pedidoItemDTO) {
        Produto produto = produtoService.findById(pedidoItemDTO.getProdutoId());
        pedidoItem.setProduto(produto);
        pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
    }

    public void deletarItem(PedidoItemPK id){
        pedidoItemRepository.deleteById(id);
    }*/

}
