package br.com.acert.controledeliveryapi.controller.apidoc;

import br.com.acert.controledeliveryapi.dto.ProdutoDTO;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import br.com.acert.controledeliveryapi.model.Produto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Produto Controller Swagger")
public interface IProdutoControllerApiDocs {

    @ApiOperation("Buscar todas os produtos")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Produto.class)})
    public ResponseEntity<List<Produto>> findAll();

    @ApiOperation("Buscar produto por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Produto.class)})
    public ResponseEntity<Produto> findById(@PathVariable Long id);
    @ApiOperation("Cadastrando novo produto")
    @ApiResponses({@ApiResponse(code = 201, message = "OK", response = ProdutoDTO.class)})
    public Produto cadastroProduto(@ApiParam(name = "corpo", value = "Valores para cadastrar  produto",
            required = true) @RequestBody ProdutoDTO produtoDTO);

    @ApiOperation("Alterar novo produto")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ProdutoDTO.class)})
    public ResponseEntity<Produto> alterarProduto(@ApiParam(name = "corpo", value = "Valores para alterar  produto",
            required = true) @PathVariable Long id, @RequestBody ProdutoDTO produtoDTO);

    @ApiOperation("Deletar um produto")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ProdutoDTO.class)})
    public ResponseEntity<Void> delete(@PathVariable Long id);
}
