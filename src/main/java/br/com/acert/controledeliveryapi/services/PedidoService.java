package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.PedidoDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.model.Pedido;
import br.com.acert.controledeliveryapi.model.enums.PedidoStatus;
import br.com.acert.controledeliveryapi.model.form.PedidoForm;
import br.com.acert.controledeliveryapi.model.form.PedidoForm2;
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

    public Pedido solicitar(PedidoForm pedidoForm){
        Entrega entrega = entregaService.buscarPorId(pedidoForm.getEntregaId());
        Cliente cliente = clienteService.buscarPorId(pedidoForm.getClienteId());
        Pedido pedido = new Pedido();
        pedido.setEntraga(entrega);
        pedido.setCliente(cliente);
        pedido.setObservacao(pedidoForm.getObservacao());
        pedido.setTipoPagamento(pedidoForm.getTipoPagamento());

        return repository.save(pedido);
    }


    public Pedido alterarPedido( Long id, PedidoForm2 pedidoForm){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
            alterarDadosPedido(pedido.get(), pedidoForm);
            return  repository.save(pedido.get());
        }
        throw new RuntimeException("Pedido não encontrado!");
    }

    public void deletarPedido(Long id){
        repository.deleteById(id);
    }

    private void alterarDadosPedido(Pedido pedido, PedidoForm2 pedidoForm) {
        pedido.setPedidoStatus(pedidoForm.getPedidoStatus());
        pedido.setMomento(Instant.now());
        pedido.setObservacao(pedidoForm.getObservacao());
        pedido.setTipoPagamento(pedidoForm.getTipoPagamento());
    }
}
