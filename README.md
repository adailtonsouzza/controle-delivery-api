# controle-delivery-api

Para fazer qualquer tipo de requisição temos que ter o token,
deixei um cliente já criado para gerar o token o campo (nome) é nosso atribudo para usuario então: nome: admin, senha: admin.


endpoints
GetAll
/login

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

Post
/login

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

GetId
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

Put
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

Delete
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

!!IMPORTANTE 

Para um bom funcionamento da API temos que seguir um fluxo.

1° Gerar o token (Com o usuario admin) 
{"nome": admin, "senha": "admin"}
2° Criar um cliente caso acha necessário ou usar o admin.
{
"nome": "string",
"telefone": "string",
"senha": "string"
}
3° Cadastrar um endereço para Entrega
{   
    "nome": "string",
    "logradouro": "string",
    "numero": "string",
    "complemento": "string",
    "bairro": "string"  
}
4° Cadastrar vários ou um produto, fica a seu critério.
{
    "nome": "String",
    "descricao": "String",
    "preco": 8.50
}
5° Inserir um novo pedido 
    {
    "observacao": "string ",
    "tipoPagamento": "string",
    "entregaId":1 ,
    "clienteId":1 
    }
6° Adicionar um PedidoItem que é a ligação dos produtos com o pedido que o cliente criou.
{
    "pedidoId": 1,
    "produtoId": 1,
    "quantidade": 3
}
Obs:Podemos adicionar vários produtos em um só pedido, pra isso é só deixar o Id do mesmo peiddo e ir alterando o Id do produto. 
