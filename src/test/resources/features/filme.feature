#language:pt

@regressivo @filmes
Funcionalidade: CRUD Filmes

  @post
  Cenario: Cadastrar Filme
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo POST de Filmes
    Entao valido que recebo status 201 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
    E armazeno o id que recebo do response de Filmes

  @get
  Cenario: Consultar Filme apos cadastro
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes
    Entao valido que recebo status 200 no response
    E valido que no campo "nome[5]" possui o valor "Black Adam"

  @put
  Cenario: Alterar Filme
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando altero o indice 1 da lista de categorias de Filme com os valores
      | tipo | Drama |
    Quando realizo uma requisicao do tipo PUT de Filmes
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Drama"