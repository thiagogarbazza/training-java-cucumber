# language: pt

Funcionalidade: Contar a qualtidade de dias úteis entre duas datas.

  Contexto:
    Dado considerando que o dia "12/10/2018" é feriado.
    E considerando que o dia "02/11/2018" é feriado.
    E considerando que o dia "15/11/2018" é feriado.

  Cenário: Contar a quantidade de dias úteis.
    Dado entre as datas "01/10/2018" e "14/10/2018".
    Quando perguntamos quantos dias úteis existem.
    Então o sistema responde que são "9" dias úteis.

  Cenário: Contar a quantidade de dias úteis.
    Dado entre as datas "01/11/2018" e "16/11/2018".
    Quando perguntamos quantos dias úteis existem.
    Então o sistema responde que são "10" dias úteis.
