package br.com.acert.controledeliveryapi.controller;

import br.com.acert.controledeliveryapi.dto.ProdutoDTO;
import br.com.acert.controledeliveryapi.model.Produto;
import br.com.acert.controledeliveryapi.model.form.ProdutoForm;
import br.com.acert.controledeliveryapi.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Produto Controller")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Operation(summary = "Retorna todos os protudos")
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> list = service.findAll();
        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Retorna os produtos por ID")
    @GetMapping(value =  "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @Operation(summary = "Cadastra um novo produto")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto cadastroProduto(@RequestBody ProdutoForm produtoDTO){
        Produto produto = service.adicionandoProduto(produtoDTO);
        return produto;
    }

    @Operation(summary = "Alterar um novo produto")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody ProdutoForm produtoDTO){
        Produto produto = service.alterarProduto(id, produtoDTO);
        return ResponseEntity.ok().body(produto);
    }

    @Operation(summary = "Deleta produto por ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deletarProduto(id);
        return  ResponseEntity.noContent().build();
    }


}
