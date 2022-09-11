package br.com.acert.controledeliveryapi.controller.apidoc;

import br.com.acert.controledeliveryapi.dto.EntregaDTO;
import br.com.acert.controledeliveryapi.model.Cliente;
import br.com.acert.controledeliveryapi.model.Entrega;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Entrega Controller Swagger")
public interface IEntregaControllerApiDocs {

    @ApiOperation("Buscar todas as entregas")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Entrega.class)})
    public ResponseEntity<List<Entrega>> buscarTodasEntregas();

    @ApiOperation("Buscar por id entregas")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Entrega.class)})
    public ResponseEntity<Entrega> buscarEntregaPorId(@PathVariable Long id);

    @ApiOperation("Adicionar um endereço")
    @ApiResponses({@ApiResponse(code = 201, message = "OK", response = Entrega.class)})
    public Entrega cadastroEntrega(@ApiParam(name = "corpo", value = "Valores para adicionar um endereco",
            required = true) @RequestBody EntregaDTO entregaDTO);

    @ApiOperation("Alterar um endereço")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Entrega.class)})
    public ResponseEntity<Entrega> alterarEndereco(@ApiParam(name = "corpo", value = "Valores para alterar um endereco",
            required = true) @PathVariable Long id, @RequestBody EntregaDTO entregaDTO);

    @ApiOperation("Deletar um endereço")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Entrega.class)})
    public ResponseEntity<Void> delete(@PathVariable Long id);
}
