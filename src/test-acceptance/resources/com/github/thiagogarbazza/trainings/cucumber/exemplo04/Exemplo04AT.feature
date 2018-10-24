# language: pt

Funcionalidade: Contar a qualtidade de dias úteis entre duas datas.

  Cenário: Contar a quantidade de dias úteis.
    Dado entre as datas "01/10/2018" e "14/10/2018".
    E considerando que o dia "12/10/2018" é feriado.
    E considerando que o dia "02/11/2018" é feriado.
    E considerando que o dia "15/11/2018" é feriado.
    E considerando que o dia "08/12/2018" é feriado.
    Quando perguntamos quantos dias úteis existem.
    Então o sistema responde que são "9" dias úteis.

  Cenário: Contar a quantidade de dias úteis.
    Dado entre as datas "01/10/2018" e "14/10/2018".
    E considerando os feriados abaixo:
      | 12/10/2018 |
      | 02/11/2018 |
      | 15/11/2018 |
      | 08/12/2018 |
    Quando perguntamos quantos dias úteis existem.
    Então o sistema responde que são "9" dias úteis.


  Esquema do Cenário: Contar a quantidade de dias úteis.
    Dado entre as datas "<data 1>" e "<data 2>".
    E considerando os feriados abaixo:
      | 12/10/2018 |
      | 02/11/2018 |
      | 15/11/2018 |
      | 08/12/2018 |
    Quando perguntamos quantos dias úteis existem.
    Então o sistema responde que são "<resultado>" dias úteis.
    Exemplos:
      | data 1     | data 2     | resultado |
      | 01/10/2018 | 14/10/2018 | 9         |
      | 01/11/2018 | 16/11/2018 | 10        |
      | 01/12/2018 | 16/12/2018 | 10        |
