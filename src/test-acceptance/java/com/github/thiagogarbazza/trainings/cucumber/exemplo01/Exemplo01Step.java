package com.github.thiagogarbazza.trainings.cucumber.exemplo01;

import com.github.thiagogarbazza.trainings.cucumber.CalendarioService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.time.LocalDate;

import static com.github.thiagogarbazza.trainings.cucumber.CalendarioService.getCalendarioService;
import static org.junit.Assert.assertFalse;

public class Exemplo01Step {

  private CalendarioService calendarioService = getCalendarioService();
  private LocalDate data;
  private Boolean eFeriado;

  @Before
  public void before() {
    data = null;
    eFeriado = null;
    CalendarioService.FERIADOS.clear();
    CalendarioService.FERIADOS.add(LocalDate.of(2018, 1, 1));
  }

  @Dado("^o dia (\\d+)/(\\d+)/(\\d+)\\.$")
  public void oDia(int arg0, int arg1, int arg2) {
    data = LocalDate.of(arg2, arg1, arg0);
  }

  @Então("^o sistema responde que não\\.$")
  public void oSistemaRespondeQueNão() {
    assertFalse(eFeriado);
  }

  @Quando("^perguntamos se é feriado\\.$")
  public void perguntamosSeÉFeriado() {
    eFeriado = calendarioService.eFeriado(data);
  }
}
