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

    @getAposInclusao
  Cenario: Consultar Filme após cadastro
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes pelo nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"
  @get
  Cenario: Consultar Filmes
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes
    Entao valido que recebo status 200 no response

  @getNome
  Cenario: Consultar Filme pelo nome
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes pelo nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"
  @put
  Cenario: Alterar Filme
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando altero o indice 0 da lista de categorias de Filme com os valores
      | tipo | Drama |
    Quando altero o indice 1 da lista de categorias de Filme com os valores
      | tipo | Terror |
    Quando realizo uma requisicao do tipo PUT de Filmes
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[0]" possui o valor "Drama"
    E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

  @getAposAlteracao
  Cenario: Consultar Filme após cadastro
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes pelo nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[0]" possui o valor "Drama"
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

  @delete
  Cenario: Deletar Filme
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando realizo uma requisicao do tipo DELETE de Filmes
    Entao valido que recebo status 200 no response

  @getAposExclusao
  Cenario: Consultar Filmes apos exclusao
    Dado que tenha realizado o login com dados validos
    E que tenho um payload valido da API de Filmes
    Quando envio uma requisicao do tipo GET de Filmes pelo nome
    Entao valido que recebo status 200 no response
    E valido que recebo uma lista vazia no response
