#language: pt
#encoding: UTF-8
#Author: Jardeson Santos


@regressivo @login
Funcionalidade: Realizar Login
  Testes da API de Login

  @payloadValido
  Cenario: Realizar login com sucesso
    Dado que tenho um payload valido da API de Login
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  @payloadInvalido
  Esquema do Cenario: <id>
    Dado que tenho um payload invalido da API de Login
      | email | <email> |
      | senha | <senha> |
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 400 no response

    @emailInvalido
    Exemplos:
      | id                                | email              | senha  |
      | Realizar login com email invalido | invalido@email.com | 123456 |
      | Realizar login com email []       | [1,2]              | 123456 |
      | Realizar login com email true     | true               | 123456 |
      | Realizar login com email null     |                    | 123456 |

    @senhaInvalida
    Exemplos:
      | id                                | email           | senha    |
      | Realizar login com senha invalida | aluno@email.com | invalida |
      | Realizar login com senha {[]}     | [1,2]           | 123456   |
      | Realizar login com senha true     | true            | 123456   |
      | Realizar login com senha null     |                 | 123456   |
