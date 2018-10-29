# language: pt

Funcionalidade: Detalhar interações para o sistema em desenvolvimento.

  Contexto:
    Dado que os sistemas abaixo estão cadastrados:
      | id | Sigla | Nome                    | Situação |
      | 1  | EDD   | Editor de documentos    | Ativo    |
      | 2  | SDN   | Sistema de notificações | Inativo  |
    E que as interações abaixo estão cadastradas:
      | id | Sistema | Data início | Data fim   | Nome       |
      | 1  | SDN     | 22/10/2018  | 26/10/2018 | Sprint 001 |
      | 2  | EDD     | 15/10/2018  | 19/10/2018 | Sprint 001 |
      | 3  | EDD     | 22/10/2018  | 26/10/2018 | Sprint 002 |

  @Ignore # seguranca ainda não implementada
  Cenário: 01. Não permitir que um usuário não autorizado execute a ação.
    Dado que o usuário "Zoraide Silva" esta logado no sistema.
    E solicita o detalhamento da interação "Sprint 002" do sistema "EDD".
    Quando clicar no botão detalhar.
    Então o sistema responde que "Usuário não autorizado.".

  Cenário: 02. Realizar um detalhamento com sucesso.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E solicita o detalhamento da interação "Sprint 002" do sistema "EDD".
    Quando clicar no botão detalhar.
    Então o sistema responde a interação abaixo:
      | id | Sistema | Data início | Data fim   | Nome       |
      | 3  | EDD     | 22/10/2018  | 26/10/2018 | Sprint 002 |
