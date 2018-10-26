package com.github.thiagogarbazza.trainings.cucumber.exemplo05;

import com.github.thiagogarbazza.trainings.cucumber.CalendarioService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.BooleanUtils;

import java.time.LocalDate;

import static com.github.thiagogarbazza.trainings.cucumber.CalendarioService.getCalendarioService;
import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;
import static org.junit.Assert.assertEquals;

public class Exemplo05Step {

  private CalendarioService calendarioService = getCalendarioService();
  private LocalDate data;
  private Boolean eFeriado;

  @Before
  public void before() {
    data = null;
    eFeriado = null;
    CalendarioService.FERIADOS.clear();
  }

  @Dado("^considerando que o dia \"([^\"]*)\" é feriado\\.$")
  public void contextoConsiderandoQueODiaÉFeriado(String arg0) {
    CalendarioService.FERIADOS.add(toLocalDate(arg0));
  }

  @Dado("^o dia (\\d+)/(\\d+)/(\\d+)\\.$")
  public void oDia(int arg0, int arg1, int arg2) {
    data = LocalDate.of(arg2, arg1, arg0);
  }

  @Então("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondeQue(String esperado) {
    assertEquals(BooleanUtils.toBoolean(esperado.toLowerCase(), "sim", "não"), eFeriado);
  }

  @Quando("^perguntamos se é feriado\\.$")
  public void perguntamosSeÉFeriado() {
    eFeriado = calendarioService.eFeriado(data);
  }
}
