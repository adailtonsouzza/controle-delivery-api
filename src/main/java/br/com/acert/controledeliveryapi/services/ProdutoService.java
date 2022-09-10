package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.ProdutoDTO;
import br.com.acert.controledeliveryapi.model.Produto;
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

    public Produto adicionandoProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return repository.save(produto);
    }

    public Produto alterarProduto(Long id, ProdutoDTO produtoDTO){
        Produto produto = repository.getOne(id);
        alterarDadosProduto(produto, produtoDTO);
        return  repository.save(produto);
    }

    private void alterarDadosProduto(Produto produto, ProdutoDTO produtoDTO) {
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }


}
