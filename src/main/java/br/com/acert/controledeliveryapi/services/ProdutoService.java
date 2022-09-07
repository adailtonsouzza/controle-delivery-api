package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.entities.Produto;
import br.com.acert.controledeliveryapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public List<Produto> findAll(){
        return repository.findAll();
    }


    public Produto findById(Long id){
       Optional<Produto> obj =  repository.findById(id);
       return obj.get();
    }
}
