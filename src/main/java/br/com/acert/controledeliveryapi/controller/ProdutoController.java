package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.controller.apidoc.IProdutoControllerApiDocs;
import br.com.acert.controledeliveryapi.dto.ProdutoDTO;
import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController implements IProdutoControllerApiDocs {

    @Autowired
    private ProdutoService service;
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto cadastroProduto(@RequestBody  ProdutoDTO produtoDTO){
        Produto produto = service.adicionandoProduto(produtoDTO);
        return produto;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        Produto produto = service.alterarProduto(id, produtoDTO);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletarProduto(id);
        return  ResponseEntity.noContent().build();
    }


}
