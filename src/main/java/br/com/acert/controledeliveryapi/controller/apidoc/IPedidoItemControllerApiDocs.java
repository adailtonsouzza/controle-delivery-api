package br.com.acert.controledeliveryapi.controller.apidoc;

import br.com.acert.controledeliveryapi.dto.PedidoItemDTO;
import br.com.acert.controledeliveryapi.model.PedidoItem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "PedidoItem Controller Swagger")
public interface IPedidoItemControllerApiDocs {

    @ApiOperation("Buscar todas os pedidosItem")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PedidoItem.class)})
    public ResponseEntity<List<PedidoItem>> buscarTodosItens();

    @ApiOperation("Adicionando Itens")
    @ApiResponses({@ApiResponse(code = 201, message = "OK", response = PedidoItem.class)})
    public PedidoItem adicionandoItens(
            @ApiParam(name = "corpo", value = "Valores para adicionar itens",
                    required = true)
            @RequestBody PedidoItemDTO pedidoItemDTO);



}
