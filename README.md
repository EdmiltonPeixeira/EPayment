<h1 align="center">Projeto EPayment - Gerenciador de pagamentos</h1>

<div align="left"><h3>O projeto consiste em uma API Rest, desenvolvida com as seguintes tecnologias:</h3>
<ul>
  <li>Java 17</li>
  <li>Spring Boot</li>
  <li>Maven</li>
  <li>Java Persistence Api - JPA</li>
  <li>Banco de Dados H2</li>
</ul>
</div>

<div align="left"><h3>Para executar o projeto:</h3>
<ul>
  <li>Importe o projeto como Projeto Maven (por url ou arquivo baixado).</li>
  <li>Após importar, tente atualizar as dependências do maven pela IDE que estiver utilizando.</li>
  <li>Feita a atualização/download das dependências configuradas para o projeto, execute o projeto. Por padrão iniciará na porta 8080.</li>
  <li>Como está sendo utilizado o banco de dados H2, não é necessário se preocupar com as configurações do banco, pois já estão pré-definidas no arquivo application.properties.</li>
  <li>Para testar os endpoints, importe a collection do postman disponibilizada no repositório.</li>
  <li>Qualquer dúvida ou problema com alguma etapa, estou disponível para contato por e-mail e no linkedin, com links disponíveis em: https://github.com/EdmiltonPeixeira.</li>
</ul>
</div>

<div align="left"><h3>Informações sobre a regra de negócio:</h3>
<ul>
  <li>No endpoint /epayment/pagamentos/filtros (GET), os parâmetros de requisição não são obrigatórios. Então é possível enviar apenas alguns ou todos os parâmetros, e ainda assim uma resposta será obtida.</li>
</ul>
</div>


<div align="left"><h3>Documentação Swagger:</h3>
<ul>
  <li>Para visualizar a documentação da API no Swagger, após iniciar a aplicação acesse o endereço http://localhost:8080/swagger-ui/index.html#/</li>
</ul>
</div>
