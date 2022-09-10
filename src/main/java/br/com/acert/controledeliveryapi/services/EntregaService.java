package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.EntregaDTO;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.repositories.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository repository;




    public List<Entrega> buscarTodasEntregas(){
        return  repository.findAll();
    }

    public Entrega buscarPorId(Long id){
        Optional<Entrega> entrega = repository.findById(id);
        return  entrega.get();
    }

    public Entrega cadastrarEndercoDaEntrega(EntregaDTO entregaDTO){
        Entrega entrega = new Entrega();
        entrega.setNome(entregaDTO.getNome());
        entrega.setLogradouro(entregaDTO.getLogradouro());
        entrega.setNumero(entregaDTO.getNumero());
        entrega.setBairro(entregaDTO.getBairro());
        entrega.setComplemento(entregaDTO.getComplemento());

        return repository.save(entrega);

    }

    public Entrega alterarEndereco(Long id, EntregaDTO entregaDTO){
        Entrega entrega = repository.getOne(id);
        alterarDadosEndereco(entrega, entregaDTO);
        return repository.save(entrega);

    }

    public void alterarDadosEndereco(Entrega entrega, EntregaDTO entregaDTO) {
        entrega.setNome(entregaDTO.getNome());
        entrega.setLogradouro(entregaDTO.getLogradouro());
        entrega.setNumero(entregaDTO.getNumero());
        entrega.setBairro(entregaDTO.getBairro());
        entrega.setComplemento(entregaDTO.getComplemento());
    }


    public void deletarEntrega(Long id){
        repository.deleteById(id);
    }


}
