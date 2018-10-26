package com.github.thiagogarbazza.trainings.cucumber.calendario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)

public class Dia {

  private static final Collection<DayOfWeek> FINAL_SEMANA = asList(SUNDAY, SATURDAY);

  private LocalDate data;
  private String descricaoFeriado;
  @Builder.Default
  private boolean feriado = false;

  public boolean util() {
    return !feriado && FINAL_SEMANA.contains(data.getDayOfWeek());
  }
}
