package com.github.thiagogarbazza.trainings.cucumber.exemplo02;

import com.github.thiagogarbazza.trainings.cucumber.CalendarioService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.time.LocalDate;

import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;
import static com.github.thiagogarbazza.trainings.cucumber.CalendarioService.getCalendarioService;
import static org.junit.Assert.assertEquals;

public class Exemplo02Step {

  private CalendarioService calendarioService = getCalendarioService();
  private LocalDate data1;
  private LocalDate data2;
  private Integer quantidadeDiasUteis;

  @Before
  public void before() {
    data1 = null;
    data2 = null;
    quantidadeDiasUteis = null;
    CalendarioService.FERIADOS.clear();
  }

  @E("^considerando que o dia \"([^\"]*)\" é feriado\\.$")
  public void considerandoQueODiaÉFeriado(String arg0) {
    CalendarioService.FERIADOS.add(toLocalDate(arg0));
  }

  @Dado("^entre as datas \"([^\"]*)\" e \"([^\"]*)\"\\.$")
  public void entreAsDatasE(String arg0, String arg1) {
    this.data1 = toLocalDate(arg0);
    this.data2 = toLocalDate(arg1);
  }

  @Então("^o sistema responde que são \"([^\"]*)\" dias úteis\\.$")
  public void oSistemaRespondeQueSãoDiasÚteis(String arg0) {
    assertEquals(Integer.valueOf(arg0), quantidadeDiasUteis);
  }

  @Quando("^perguntamos quantos dias úteis existem\\.$")
  public void perguntamosQuantosDiasÚteisExistem() {
    this.quantidadeDiasUteis = calendarioService.contarDiasUteis(data1, data2);
  }
}
