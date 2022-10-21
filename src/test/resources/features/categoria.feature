#language: pt
#encoding: UTF-8
#Author: Jardeson Santos


@regressivo @categoria
Funcionalidade: Realizar Consulta de Categoria
  Testes no endpoint de Categoria

  @payloadValidoCategoria
  Cenario: Realizar Consulta Categoria com Sucesso
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Categoria
    Quando realizo uma requisicao do tipo GET de Categoria
    Entao valido que recebo status 200 no response
    E valido que no campo "tipo[0]" possui o valor "Aventura"
    E valido que no campo "tipo[1]" possui o valor "Acao"
    E valido que no campo "tipo[2]" possui o valor "Terror"
    E valido que no campo "tipo[3]" possui o valor "Drama"
    E valido que no campo "tipo[4]" possui o valor "Comedia"
    E valido que no campo "tipo[5]" possui o valor "Sobrevivencia"
    E valido que no campo "tipo[6]" possui o valor "Crime"
    E valido que no campo "tipo[7]" possui o valor "Thriller"

  Cenario: Realizar Consulta Categoria sem token
    Quando realizo uma requisicao do tipo GET de Categoria
    Entao valido que recebo status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"
