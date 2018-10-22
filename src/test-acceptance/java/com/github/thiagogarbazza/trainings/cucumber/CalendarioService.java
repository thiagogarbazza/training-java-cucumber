package com.github.thiagogarbazza.trainings.cucumber;

import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.TreeSet;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CalendarioService {

  public static Collection<LocalDate> FERIADOS = new TreeSet<>();
  private static Collection<DayOfWeek> FINAL_SEMANA = asList(SUNDAY, SATURDAY);
  private static CalendarioService INSTANCE = new CalendarioService();

  public int contarDiasUteis(LocalDate data1, LocalDate data2) {
    LocalDate aux = data1;

    int count = 0;
    while (aux.compareTo(data2) <= 0) {
      if (!(FERIADOS.contains(aux) || FINAL_SEMANA.contains(aux.getDayOfWeek()))) {
        count++;
      }
      aux = aux.plusDays(1);
    }

    return count;
  }

  public boolean eFeriado(LocalDate localDate) {
    return FERIADOS.contains(localDate);
  }

  public static CalendarioService getCalendarioService() {
    return INSTANCE;
  }
}
