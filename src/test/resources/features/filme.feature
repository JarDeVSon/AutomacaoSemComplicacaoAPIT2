#language:pt

  @regressivo
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
      E valido que no campo "nome[6]" possui o valor "Black Adam"