# language: pt

Funcionalidade: Excluir interações para o sistema em desenvolvimento.

  Contexto:
    Dado que os sistemas abaixo estão cadastrados:
      | id | Sigla | Nome                    | Situação |
      | 1  | EDD   | Editor de documentos    | Ativo    |
      | 2  | SDN   | Sistema de notificações | Inativo  |
    E que as interações abaixo estão cadastradas:
      | id | Sistema | Data início | Data fim   | Nome       |
      | 1  | SDN     | 22/10/2018  | 26/10/2018 | Spring 001 |
      | 2  | EDD     | 15/10/2018  | 19/10/2018 | Spring 001 |
      | 3  | EDD     | 22/10/2018  | 26/10/2018 | Spring 002 |
    E que as atividades abaixo estão cadasstradas:
      | id | Sistema | Interação  | Nome                                              | Story points |
      | 1  | SDN     | Sprint 001 | Criar pop-up de notificação                       | 5            |
      | 2  | EDD     | Spring 001 | Criar funcionalidade de tornar o texto em negrito | 3            |
      | 3  | EDD     | Spring 001 | Criar funcionalidade de tornar o texto em itálico | 3            |

  Cenário: 01. Não permitir que um usuário não autorizado execute a ação.
    Dado que o usuário "Zoraide Silva" esta logado no sistema.
    E solicita a exclusão da interação "Sprint 002" do sistema "EDD".
    Quando clicar no botão excluir.
    Então o sistema responde que "Usuário não autorizado.".

  Cenário: 02. Não pode excluir interações que contenham atividades associadas.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E solicita exclusão da interação "Sprint 001" do sistema "EDD".
    Quando clicar no botão excluir.
    Então o sistema responde que "Não é permitido excluir interação que contenha atividade.".

  Cenário: 03. Realizar uma exclusão com sucesso.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E solicita exclusão da interação "Sprint 002" do sistema "EDD".
    Quando clicar no botão excluir.
    Então o sistema responde que "Interação excluída com sucesso.".
