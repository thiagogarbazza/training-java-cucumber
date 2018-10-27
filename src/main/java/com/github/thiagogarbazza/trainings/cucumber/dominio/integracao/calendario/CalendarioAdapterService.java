package com.github.thiagogarbazza.trainings.cucumber.dominio.integracao.calendario;

import java.time.LocalDate;

public interface CalendarioAdapterService {

  int contarDiasUteis(LocalDate data1, LocalDate data2);

  boolean feriado(LocalDate data);

  boolean diaUtil(LocalDate data);

  Dia buscarDia(LocalDate date);
}
