# language: pt
# encoding: utf-8
@api
Funcionalidade: Validar autenticação de Json Web Token

  - Eu, como testador, gostaria de realizar
  um Post afim de validar a autenticação,
  com base no respectivo serviço.

  @CT_001
  Cenário: Verifica se o JWT está autenticado
    Dado que tenho um token jwt
    Quando faço uma requisição de autenticação
    Então valido se os dados da api estão autenticados

  @CT_002
  Cenario:Verifica se o JWT não está autenticado
    Dado que tenho um token jwt não autenticado
    Quando faço uma requisição de autenticação
    Então valido que os dados da api não estão autenticados


  @CT_003
  Cenario: Verifica se o JWT está vazio
    Dado que tenho um token jwt vazio
    Quando faço uma requisição de autenticação
    Então valido se se o jwt está vazio

