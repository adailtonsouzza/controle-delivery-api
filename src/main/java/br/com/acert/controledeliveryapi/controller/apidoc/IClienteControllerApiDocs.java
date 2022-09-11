package br.com.acert.controledeliveryapi.controller.apidoc;

import br.com.acert.controledeliveryapi.dto.ClienteDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Cliente Controller Swagger")
public interface IClienteControllerApiDocs {
    @ApiOperation("Buscar todos os clientes")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Cliente.class)})
    public ResponseEntity<List<Cliente>> findAll();

    @ApiOperation("Buscar cliente pelo ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Cliente.class)})
    public ResponseEntity<Cliente> findById(@PathVariable Long id);

    @ApiOperation("Cadastrar um cliente.")
    @ApiResponses({@ApiResponse(code = 201, message = "OK", response = Cliente.class)})
    public Cliente cadastroCliente(
            @Valid @RequestBody @ApiParam(name = "corpo", value = "Valores para cadastrar um novos cliente",
                    required = true) ClienteDTO clienteDTO);

    @ApiOperation("Deletar um cliente.")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Cliente.class)})
    public ResponseEntity<Void> delete(@PathVariable Long id);

    @ApiOperation("Alterando um cliente.")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Cliente.class)})
    public ResponseEntity<Cliente> alterar(
            @ApiParam(name = "corpo", value = "Valores para alterar um novos cliente",
                    required = true) @PathVariable Long id, @RequestBody ClienteDTO clienteDTO);
}
