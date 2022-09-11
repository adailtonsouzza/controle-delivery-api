# controle-delivery-api

Link da API em produção: https://controle-delivery-api-pro.herokuapp.com/
</br>
</br>
Link do SWAGGER DA  API em produção: https://controle-delivery-api-pro.herokuapp.com/swagger
</br>
</br>

Link do SWAGGER DA  API em desenvolvimento: http://localhost:8080/swagger
</br>
</br>

<h1>Seguir o Passo a Passo. A partir de linha 106</h1>
<h2>Login e senha criado para realizar os testes</h2>
<h3>nome: admin</h3>
<h3>senha: admin</h3>
</br>
</br>


Para fazer qualquer tipo de requisição temos que ter o token,
deixei um cliente já criado para gerar o token o campo (nome) é nosso atribudo para usuario então: nome: admin, senha: admin.
<br>

endpoints
</br>
</br>
GetAll
</br>
</br>
/login

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

Post
</br>
</br>
/login

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

GetId
</br>
</br>
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

Put
</br>
</br>
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

Delete
</br>
</br>
/login/{id}

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}
</br>
</br>

<h1>IMPORTANTE</h1> 
</br>
</br>

Para um bom funcionamento da API temos que seguir um fluxo.
</br>
</br>

1° Gerar o token (Com o usuario admin) 
</br>
</br>
{"nome": admin, "senha": "admin"}
</br>
</br>
2° Criar um cliente caso acha necessário ou usar o admin.
</br>
</br>
{
"nome": "string",
"telefone": "string",
"senha": "string"
}
</br>
</br>
3° Cadastrar um endereço para Entrega
</br>
</br>
{   
    "nome": "string",
    "logradouro": "string",
    "numero": "string",
    "complemento": "string",
    "bairro": "string"  
}
</br>
</br>
4° Cadastrar vários ou um produto, fica a seu critério.
</br>
</br>
{
    "nome": "String",
    "descricao": "String",
    "preco": 8.50
}
</br>
</br>
5° Inserir um novo pedido 
</br>
</br>
    {
    "observacao": "string ",
    "tipoPagamento": "string",
    "entregaId":1 ,
    "clienteId":1 
    }
</br>
</br>
6° Adicionar um PedidoItem que é a ligação dos produtos com o pedido que o cliente criou.
</br>
</br>
{
    "pedidoId": 1,
    "produtoId": 1,
    "quantidade": 3
}
</br>
</br>
Obs:Podemos adicionar vários produtos em um só pedido, pra isso é só deixar o Id do mesmo peiddo e ir alterando o Id do produto. 
</br>
</br>
7° Depois que fazer o passo a passa pode dar um GET novamente em pedido por id ou buscar todos e vai ver os relacionamentos de entrega, produto e pedidos e etc...
