package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.EntregaDTO;
import br.com.acert.controledeliveryapi.model.Entrega;
import br.com.acert.controledeliveryapi.model.form.EntregaForm;
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

    public Entrega cadastrarEndercoDaEntrega(EntregaForm entregaForm){
        Entrega entrega = new Entrega();
        entrega.setNome(entregaForm.getNome());
        entrega.setLogradouro(entregaForm.getLogradouro());
        entrega.setNumero(entregaForm.getNumero());
        entrega.setBairro(entregaForm.getBairro());
        entrega.setComplemento(entregaForm.getComplemento());

        return repository.save(entrega);

    }

    public Entrega alterarEndereco(Long id, EntregaForm entregaForm){
        Optional<Entrega> entrega = repository.findById(id);
        if(entrega.isPresent()){
            alterarDadosEndereco(entrega.get(), entregaForm);
            return repository.save(entrega.get());
        }
        throw new RuntimeException("Entrega não encontrada!");

    }

    public void alterarDadosEndereco(Entrega entrega, EntregaForm entregaForm) {
        entrega.setNome(entregaForm.getNome());
        entrega.setLogradouro(entregaForm.getLogradouro());
        entrega.setNumero(entregaForm.getNumero());
        entrega.setBairro(entregaForm.getBairro());
        entrega.setComplemento(entregaForm.getComplemento());
    }


    public void deletarEntrega(Long id){
        repository.deleteById(id);
    }


}
