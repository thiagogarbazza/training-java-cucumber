# language: pt

Funcionalidade: Pesquisar interações para o sistema em desenvolvimento.

  Contexto:
    Dado que as datas abaixo são feriados:
      | data       | feriado | descrição do feriado                   |
      | 12/10/2018 | Sim     | Dia das crianças / Padroeira do Brasil |
      | 02/11/2018 | Sim     | Dia de finados                         |
      | 15/11/2018 | Sim     | Dia da proclamação da republica        |
      | 08/12/2018 | Sim     | Aniversário de Belo Horizonte          |
    E que os sistemas abaixo estão cadastrados:
      | id | Sigla | Nome                    | Situação |
      | 1  | EDD   | Editor de documentos    | Ativo    |
      | 2  | SDN   | Sistema de notificações | Inativo  |
    E que as interações abaixo estão cadastradas:
      | id | Sistema | Data início | Data fim   | Nome       |
      | 1  | SDN     | 22/10/2018  | 26/10/2018 | Sprint 001 |
      | 2  | EDD     | 15/10/2018  | 19/10/2018 | Sprint 001 |
      | 3  | EDD     | 22/10/2018  | 26/10/2018 | Sprint 002 |
    E que as atividades abaixo estão cadasstradas:
      | id | Sistema | Interação  | Nome                                              | Story points |
      | 1  | SDN     | Sprint 001 | Criar pop-up de notificação                       | 5            |
      | 2  | EDD     | Sprint 001 | Criar funcionalidade de tornar o texto em negrito | 3            |
      | 3  | EDD     | Sprint 001 | Criar funcionalidade de tornar o texto em itálico | 3            |

  @Ignore # seguranca ainda não implementada
  Cenário: 01. Não permitir que um usuário não autorizado execute a ação.
    Dado que o usuário "Zoraide Silva" esta logado no sistema.
    E selecionou o filtro sistema "".
    E informou o filtro nome "001".
    Quando clicar no botão pesquisar.
    Então o sistema responde que "Usuário não autorizado.".

  Cenário: 02. Realizar pesquisa.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E selecionou o filtro sistema "".
    E informou o filtro nome "".
    Quando clicar no botão pesquisar.
    Então o sistema responde que "Deve ser utilizado ao menos 1 filtro.".

  Cenário: 03. Realizar pesquisa informando o sistema.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E selecionou o filtro sistema "EDD".
    E informou o filtro nome "".
    Quando clicar no botão pesquisar.
    Então o sistema responde as interações abaixo:
      | id | Sistema | Data início | Data fim   | Nome       | Atividades |
      | 3  | EDD     | 22/10/2018  | 26/10/2018 | Sprint 002 | 0          |
      | 2  | EDD     | 15/10/2018  | 19/10/2018 | Sprint 001 | 2          |

  Cenário: 04. Realizar pesquisa informando um nome que não existe na base.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E selecionou o filtro sistema "".
    E informou o filtro nome "Teste".
    Quando clicar no botão pesquisar.
    Então o sistema responde as interações abaixo:
      | id | Sistema | Data início | Data fim | Nome | Atividades |

  Cenário: 05. Realizar pesquisa informando uma parte do nome.
    Dado que o usuário "Thiago Garbazza" esta logado no sistema.
    E selecionou o filtro sistema "".
    E informou o filtro nome "001".
    Quando clicar no botão pesquisar.
    Então o sistema responde as interações abaixo:
      | id | Sistema | Data início | Data fim   | Nome       | Atividades |
      | 1  | SDN     | 22/10/2018  | 26/10/2018 | Sprint 001 | 1          |
      | 2  | EDD     | 15/10/2018  | 19/10/2018 | Sprint 001 | 2          |
