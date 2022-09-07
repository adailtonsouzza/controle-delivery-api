package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.entities.Categoria;
import br.com.acert.controledeliveryapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;


    public List<Categoria> findAll(){
        return repository.findAll();
    }


    public Categoria findById(Long id){
       Optional<Categoria> obj =  repository.findById(id);
       return obj.get();
    }
}
