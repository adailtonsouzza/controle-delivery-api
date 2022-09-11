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

<h1>endpoints</h1>
</br>
</br>
<h2>Get</h2>
</br>
</br>

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

<h2>Post</h2>
</br>
</br>
/login

/clientes

/pedidos

/entregas

/produtos

/pedidoItens

<h2>GetId</h2>
</br>
</br>

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

<h2>Put</h2>
</br>
</br>

/clientes/{id}

/pedidos/{id}

/entregas/{id}

/produtos/{id}

/pedidoItens/{id}

<h2>Delete</h2>
</br>
</br>

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

<h2>Para um bom funcionamento da API seguir um fluxo.</h2>
</br>
</br>

<h3>1° Gerar o token (Com o usuario admin)</h3>
<h4>Para realizar os testes no Swagger, pegar o token gerado pelo POSTMAN ou alguma ferramente de preferência. Não precisar copiar o BEARER.</h4>
<h5>Já existe um usuário criado, só seguir o JSON abaixo para realizar o login</h5>
</br>
</br>
{"nome": admin, "senha": "admin"}
</br>
</br>
<h3>2° Criar um cliente caso acha necessário ou usar o admin.</h3>
</br>
</br>
{
"nome": "string",
"telefone": "string",
"senha": "string"
}
</br>
</br>
<h3>3° Cadastrar um endereço para Entrega</h3>
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
<h3>4° Cadastrar vários ou um produto, fica a seu critério.</h3>
</br>
</br>
{
    "nome": "String",
    "descricao": "String",
    "preco": 8.50
}
</br>
</br>
<h3>5° Inserir um novo pedido </h3>
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
<h3>6° Adicionar um PedidoItem que é a ligação dos produtos com o pedido que o cliente criou.</h3>
</br>
</br>
{
    "pedidoId": 1,
    "produtoId": 1,
    "quantidade": 3
}
</br>
</br>
<h3>Obs:Podemos adicionar vários produtos em um só pedido, pra isso é só deixar o Id do mesmo peiddo e ir alterando o Id do produto. </h3>
</br>
</br>
<h3>7° Depois que fazer o passo a passa pode dar um GET novamente em pedido por id ou buscar todos e vai ver os relacionamentos de entrega, produto e pedidos e etc...</h3>
