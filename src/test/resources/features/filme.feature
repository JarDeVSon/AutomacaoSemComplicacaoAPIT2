#language:pt

  @regressivo
  Funcionalidade: CRUD Filmes

    @post
    Cenario: Cadastrar Filme
      Dado que tenha realizado o login com dados validos
      E que tenho um payload valido da API de Filmes
      Quando envio uma requisicao do tipo POST de Filmes
      Entao valido que recebo status 201 no response
      E valido que no campo "tipo[0]" possui o valor "Terror"
      E armazeno o id que recebo do response de Filmes