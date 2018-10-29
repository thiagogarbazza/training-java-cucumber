package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import com.github.thiagogarbazza.trainings.cucumber.dominio.integracao.calendario.Dia;
import com.github.thiagogarbazza.trainings.cucumber.dominio.integracao.calendario.CalendarioAdapterStub;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;
import static org.apache.commons.lang3.BooleanUtils.toBoolean;

public class CalendarioAdapterStep {

  @Autowired
  private CalendarioAdapterStub calendarioAdapterStub;

  @Before
  public void before() {
    calendarioAdapterStub.clear();
  }

  @E("^que as datas abaixo são feriados:$")
  public void queAsDatasAbaixoSaoFeriados(DataTable dataTable) {
    dataTable.cells().stream().skip(1).forEach(r -> CalendarioAdapterStub.FERIADOS.add(Dia.builder()
        .data(toLocalDate(r.get(0)))
        .feriado(toBoolean(r.get(1), "Sim", "Não"))
        .descricaoFeriado(r.get(2))
        .build()));
  }
}
