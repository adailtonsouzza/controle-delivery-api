package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.PedidoDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.enums.PedidoStatus;
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

    @Autowired
    private EntregaService entregaService;


    public List<Pedido> findAll(){
        return repository.findAll();
    }


    public Pedido findById(Long id){
        Optional<Pedido> obj =  repository.findById(id);
        return obj.get();
    }

    public Pedido solicitar(PedidoDTO pedidoDTO){
        Entrega entrega = entregaService.buscarPorId(pedidoDTO.getEntregaId());
        Cliente cliente = clienteService.buscarPorId(pedidoDTO.getClienteId());
        Pedido pedido = new Pedido();
        pedido.setEntraga(entrega);
        pedido.setCliente(cliente);
      //  pedido.setProdutos(pedidoDTO.getProdutos());
        pedido.setPedidoStatus(PedidoStatus.ANDAMENTO);
        pedido.setMomento(Instant.now());
        pedido.setObservacao(pedidoDTO.getObservacao());
        pedido.setTipoPagamento(pedidoDTO.getTipoPagamento());

        return repository.save(pedido);
    }


    public Pedido alterarPedido( Long id, PedidoDTO pedidoDTO){
        Pedido pedido = repository.getOne(id);
        alterarDadosPedido(pedido, pedidoDTO);
       return  repository.save(pedido);
    }

    private void alterarDadosPedido(Pedido pedido, PedidoDTO pedidoDTO) {
        pedido.setPedidoStatus(pedidoDTO.getPedidoStatus());
        pedido.setMomento(Instant.now());
        pedido.setObservacao(pedidoDTO.getObservacao());
        pedido.setTipoPagamento(pedidoDTO.getTipoPagamento());
    }

    public void deletarPedido(Long id){
        repository.deleteById(id);
    }
}
