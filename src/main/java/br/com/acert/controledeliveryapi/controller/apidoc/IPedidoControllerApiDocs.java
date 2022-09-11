package br.com.acert.controledeliveryapi.controller.apidoc;

import br.com.acert.controledeliveryapi.dto.PedidoDTO;
import br.com.acert.controledeliveryapi.model.Pedido;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pedido Controller Swagger")
public interface IPedidoControllerApiDocs {

    @ApiOperation("Buscar todas os pedidos")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Pedido.class)})
    public ResponseEntity<List<Pedido>> findAll();

    @ApiOperation("Buscar pedidos por ID ")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Pedido.class)})
    public ResponseEntity<Pedido> findById(@PathVariable Long id);
    @ApiOperation("Solicitando um pedido")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PedidoDTO.class)})
    public Pedido solicitar(@ApiParam(name = "corpo", value = "Valores para solicitar um pedido",
            required = true) @RequestBody PedidoDTO pedidoDTO);

    @ApiOperation("Alterando um pedido")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PedidoDTO.class)})
    public ResponseEntity<Pedido> alterarPedido(@ApiParam(name = "corpo", value = "Valores para solicitar um pedido",
            required = true) @PathVariable Long id, @RequestBody PedidoDTO pedidoDTO);

    @ApiOperation("Deletando um pedido")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PedidoDTO.class)})
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id);
}
