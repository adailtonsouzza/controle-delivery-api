package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.ProdutoInputDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.model.enums.TipoPagamento;
import br.com.acert.controledeliveryapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {


    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteService clienteService;


    public List<Pedido> findAll(){
        return repository.findAll();
    }


    public Pedido findById(Long id){
        Optional<Pedido> obj =  repository.findById(id);
        return obj.get();
    }

    public Pedido solicitar(ProdutoInputDTO produtoInputDTO){
        Cliente cliente = clienteService.buscarPorId(produtoInputDTO.getClienteId());
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProdutos(produtoInputDTO.getProdutos());
        pedido.setPedidoStatus(PedidoStatus.ANDAMENTO);
        pedido.setMomento(Instant.now());
        pedido.setTipoPagamento(produtoInputDTO.getTipoPagamento());


        return repository.save(pedido);
    }
}
