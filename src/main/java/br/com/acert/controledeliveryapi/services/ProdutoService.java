package br.com.acert.controledeliveryapi.services;

import br.com.acert.controledeliveryapi.dto.ProdutoDTO;
import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.model.form.ProdutoForm;
import br.com.acert.controledeliveryapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public List<ProdutoDTO> findAll(){
        return  ProdutoDTO.converter(repository.findAll());
    }


    public Produto findById(Long id){
       Optional<Produto> obj =  repository.findById(id);
       return obj.get();
    }

    public Produto adicionandoProduto(ProdutoForm produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return repository.save(produto);
    }

    public Produto alterarProduto(Long id, ProdutoForm produtoDTO){
        Optional<Produto> produto = repository.findById(id);
        if (produto.isPresent()){
            alterarDadosProduto(produto.get(), produtoDTO);
            return  repository.save(produto.get());
        }
        throw new RuntimeException("Produto não encontrado!");

    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }

    private void alterarDadosProduto(Produto produto, ProdutoForm produtoDTO) {
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
    }

}
