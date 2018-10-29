package com.github.thiagogarbazza.trainings.cucumber.dominio.integracao.calendario;

import org.springframework.boot.test.context.TestConfiguration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.Arrays.asList;

@TestConfiguration
public class CalendarioAdapterStub implements CalendarioAdapter {

  public static final Collection<Dia> FERIADOS = new ArrayList<>();
  private static final Collection<DayOfWeek> FINAL_SEMANA = asList(SUNDAY, SATURDAY);

  @Override
  public boolean diaUtil(final LocalDate data) {
    return !FERIADOS.stream().anyMatch(d -> d.getData().equals(data)) && !FINAL_SEMANA.contains(data.getDayOfWeek());
  }

  public void clear() {
    FERIADOS.clear();
  }
}
