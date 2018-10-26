# language: pt

Funcionalidade: Verificar se o dia é feriado.
  Todos nos amamos feriado.

  Contexto:
    Dado considerando que o dia "12/10/2018" é feriado.

  Cenário: Verificar se o dia informado é um feriado.
    Dado o dia 01/10/2018.
    Quando perguntamos se é feriado.
    Então o sistema responde que "não".

  Cenário: Verificar se o dia informado é um feriado.
    Dado o dia 12/10/2018.
    Quando perguntamos se é feriado.
    Então o sistema responde que "sim".

